package com.bazan.sporteventmanager.users.api;

import com.bazan.sporteventmanager.users.UserApi;
import com.bazan.sporteventmanager.users.domain.User;
import com.bazan.sporteventmanager.users.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserApiImpl implements UserApi {
    private final UserRepository userRepository;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
