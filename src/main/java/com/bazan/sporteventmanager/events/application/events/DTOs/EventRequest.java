package com.bazan.sporteventmanager.events.application.events.DTOs;

import com.bazan.sporteventmanager.events.domain.events.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventRequest(
        String title,
        String description,
        String location,
        LocalDateTime startDate,
        LocalDateTime endDate,
        EventType type,
        UUID categoryId
) {
}
