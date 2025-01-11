package com.bazan.sporteventmanager.users.application.DTOs;

public record LoginRequest(
        String email,
        String password
) {
}

