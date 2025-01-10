package com.bazan.sporteventmanager.users.application;

import com.bazan.sporteventmanager.users.contracts.UserCreatedEvent;
import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;
import com.bazan.sporteventmanager.users.domain.Role;
import com.bazan.sporteventmanager.users.domain.User;
import com.bazan.sporteventmanager.users.infrastructure.RoleRepository;
import com.bazan.sporteventmanager.users.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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

    @Override
    public UserResponse createUser(UserRequest userRequest) throws Exception {
        Role role = roleRepository.findByName(userRequest.role())
                .orElseThrow(() -> new Exception("Role not found"));


        User user = User.builder()
                .name(userRequest.name())
                .birthday(userRequest.birthDate())
                .email(userRequest.email())
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
}
