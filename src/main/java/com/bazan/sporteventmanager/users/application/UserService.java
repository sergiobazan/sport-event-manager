package com.bazan.sporteventmanager.users.application;

import com.bazan.sporteventmanager.users.application.DTOs.LoginRequest;
import com.bazan.sporteventmanager.users.application.DTOs.LoginResponse;
import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest userRequest) throws Exception;
    UserResponse getUserById(UUID id) throws Exception;
    List<UserResponse> getAllUsers();
    LoginResponse loginUser(LoginRequest loginRequest) throws Exception;
}
