package com.bazan.sporteventmanager.events.infrastructure.events;

import com.bazan.sporteventmanager.events.domain.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
