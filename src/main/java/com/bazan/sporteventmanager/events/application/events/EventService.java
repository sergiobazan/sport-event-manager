package com.bazan.sporteventmanager.events.application.events;

import com.bazan.sporteventmanager.events.application.events.DTOs.EventRequest;
import com.bazan.sporteventmanager.events.application.events.DTOs.EventResponse;

import java.util.List;
import java.util.UUID;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequest) throws Exception;
    List<EventResponse> getAllEvents();
    EventResponse getEventById(UUID id) throws Exception;
}
