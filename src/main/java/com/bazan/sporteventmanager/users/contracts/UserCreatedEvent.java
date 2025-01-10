package com.bazan.sporteventmanager.users.contracts;

import java.util.UUID;

public record UserCreatedEvent(
        UUID id,
        String name,
        String email
) {
}
