package com.bazan.sporteventmanager.events.presentation;

import com.bazan.sporteventmanager.events.application.events.DTOs.EventRequest;
import com.bazan.sporteventmanager.events.application.events.DTOs.EventResponse;
import com.bazan.sporteventmanager.events.application.events.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
class EventsController {
    private final EventService eventService;

    @GetMapping
    ResponseEntity<List<EventResponse>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("{id}")
    ResponseEntity<EventResponse> getEventById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(eventService.getEventById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest) {
        try {
            return ResponseEntity.ok(eventService.createEvent(eventRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
