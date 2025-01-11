package com.bazan.sporteventmanager.users.application.DTOs;

import java.time.LocalDate;

public record UserRequest(
        String name,
        String password,
        String email,
        String role,
        LocalDate birthDate
) {}
