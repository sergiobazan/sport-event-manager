package com.bazan.sporteventmanager.users.application.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String role,
        LocalDate birthDate
) {}
