package com.bazan.sporteventmanager.events.application.events.DTOs;

import com.bazan.sporteventmanager.events.domain.events.EventStatus;
import com.bazan.sporteventmanager.events.domain.events.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponse(
        UUID id,
        String title,
        String description,
        String location,
        LocalDateTime startDate,
        LocalDateTime endDate,
        EventStatus status,
        EventType type,
        EventCategory category
) {}

