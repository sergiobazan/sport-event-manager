package com.bazan.sporteventmanager.users.presentation;

import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;
import com.bazan.sporteventmanager.users.application.create.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
class UserController {
    private final IUserService userService;

    @PostMapping
    ResponseEntity<UserResponse> createUser(
            @RequestBody UserRequest userRequest
    ) {
        try {
            return ResponseEntity.ok(userService.createUser(userRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
