package com.bazan.sporteventmanager.users.presentation;

import com.bazan.sporteventmanager.users.application.DTOs.LoginRequest;
import com.bazan.sporteventmanager.users.application.DTOs.LoginResponse;
import com.bazan.sporteventmanager.users.application.DTOs.UserRequest;
import com.bazan.sporteventmanager.users.application.DTOs.UserResponse;
import com.bazan.sporteventmanager.users.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    ResponseEntity<UserResponse> registerUser(
            @RequestBody UserRequest userRequest
    ) {
        try {
            return ResponseEntity.ok(userService.createUser(userRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponse> loginUser(
            @RequestBody LoginRequest loginRequest
    ) {
        try {
            return ResponseEntity.ok(userService.loginUser(loginRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
