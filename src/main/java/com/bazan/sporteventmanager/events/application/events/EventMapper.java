package com.bazan.sporteventmanager.events.application.events;

import com.bazan.sporteventmanager.events.application.events.DTOs.EventCategory;
import com.bazan.sporteventmanager.events.application.events.DTOs.EventResponse;
import com.bazan.sporteventmanager.events.domain.events.Event;

public class EventMapper {
    public static EventResponse fromEvent(final Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getLocation(),
                event.getStartDate(),
                event.getEndDate(),
                event.getStatus(),
                event.getType(),
                new EventCategory(
                        event.getCategory().getId(),
                        event.getCategory().getName()
                )
        );
    }
}
