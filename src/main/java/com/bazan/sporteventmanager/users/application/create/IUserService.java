package com.bazan.sporteventmanager.users.application.create;

import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;

public interface IUserService {
    UserResponse createUser(UserRequest userRequest) throws Exception;
}
