package com.bazan.sporteventmanager.users.application;

import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;
import com.bazan.sporteventmanager.users.domain.User;

public class UserMapper {
    public static UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().getName(),
                user.getBirthday()
        );
    }
}
