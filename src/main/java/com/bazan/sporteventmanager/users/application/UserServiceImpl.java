package com.bazan.sporteventmanager.users.application;

import com.bazan.sporteventmanager.shared.JwtService;
import com.bazan.sporteventmanager.users.application.DTOs.LoginRequest;
import com.bazan.sporteventmanager.users.application.DTOs.LoginResponse;
import com.bazan.sporteventmanager.users.contracts.UserCreatedEvent;
import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;
import com.bazan.sporteventmanager.users.domain.Role;
import com.bazan.sporteventmanager.users.domain.User;
import com.bazan.sporteventmanager.users.infrastructure.RoleRepository;
import com.bazan.sporteventmanager.users.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final JwtService jwtService;

    @Override
    public UserResponse createUser(UserRequest userRequest) throws Exception {
        Role role = roleRepository.findByName(userRequest.role())
                .orElseThrow(() -> new Exception("Role not found"));

        User user = User.builder()
                .name(userRequest.name())
                .birthday(userRequest.birthDate())
                .email(userRequest.email())
                .password(encoder.encode(userRequest.password()))
                .role(role)
                .build();

        var userSaved = userRepository.save(user);

        eventPublisher.publishEvent(new UserCreatedEvent(
                userSaved.getId(),
                userSaved.getName(),
                userSaved.getEmail()
        ));

        return UserMapper.fromUser(userSaved);
    }

    @Override
    public UserResponse getUserById(UUID id) throws Exception {
        var user = userRepository.findById(id)
                    .orElseThrow(() -> new Exception("User not found"));
        return UserMapper.fromUser(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::fromUser)
                .collect(Collectors.toList());
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) throws Exception {
        User user = userRepository.findByEmail(loginRequest.email());

        if (user == null) {
            throw new Exception("Invalid credentials");
        }

        if (!encoder.matches(loginRequest.password(), user.getPassword())) {
            throw new Exception("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}
