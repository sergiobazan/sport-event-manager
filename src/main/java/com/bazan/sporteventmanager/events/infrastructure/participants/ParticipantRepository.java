package com.bazan.sporteventmanager.events.infrastructure.participants;

import com.bazan.sporteventmanager.events.domain.participants.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}
