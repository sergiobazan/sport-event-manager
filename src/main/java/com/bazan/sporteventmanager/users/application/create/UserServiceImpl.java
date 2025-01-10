package com.bazan.sporteventmanager.users.application.create;

import com.bazan.sporteventmanager.users.contracts.UserCreatedEvent;
import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;
import com.bazan.sporteventmanager.users.application.UserMapper;
import com.bazan.sporteventmanager.users.domain.Role;
import com.bazan.sporteventmanager.users.domain.User;
import com.bazan.sporteventmanager.users.infrastructure.IRoleRepository;
import com.bazan.sporteventmanager.users.infrastructure.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
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
}
