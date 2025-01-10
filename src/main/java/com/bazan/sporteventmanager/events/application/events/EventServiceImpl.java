package com.bazan.sporteventmanager.events.application.events;

import com.bazan.sporteventmanager.events.application.events.DTOs.EventRequest;
import com.bazan.sporteventmanager.events.application.events.DTOs.EventResponse;
import com.bazan.sporteventmanager.events.domain.events.Category;
import com.bazan.sporteventmanager.events.domain.events.Event;
import com.bazan.sporteventmanager.events.domain.events.EventStatus;
import com.bazan.sporteventmanager.events.infrastructure.events.CategoryRepository;
import com.bazan.sporteventmanager.events.infrastructure.events.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public EventResponse createEvent(EventRequest eventRequest) throws Exception {
        Category category = categoryRepository.findById(eventRequest.categoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        var event = Event.builder()
                .title(eventRequest.title())
                .description(eventRequest.description())
                .location(eventRequest.location())
                .startDate(eventRequest.startDate())
                .endDate(eventRequest.endDate())
                .type(eventRequest.type())
                .status(EventStatus.AVAILABLE)
                .category(category)
                .build();

        Event savedEvent = eventRepository.save(event);

        return EventMapper.fromEvent(savedEvent);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream().map(EventMapper::fromEvent)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponse getEventById(UUID id) throws Exception {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new Exception("Event not found"));
        return EventMapper.fromEvent(event);
    }
}
