package com.bazan.sporteventmanager.events.application.participants;

import com.bazan.sporteventmanager.events.domain.participants.Participant;
import com.bazan.sporteventmanager.events.infrastructure.participants.ParticipantRepository;
import com.bazan.sporteventmanager.users.contracts.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ParticipantCreatedEventHandler {
    private final ParticipantRepository participantRepository;

    @ApplicationModuleListener
    void handle(UserCreatedEvent participantCreatedEvent) {
        log.info("Starting Participant created event: {}", participantCreatedEvent);

        try {
            Participant participant = Participant.builder()
                    .id(participantCreatedEvent.id())
                    .name(participantCreatedEvent.name())
                    .email(participantCreatedEvent.email())
                    .build();
            participantRepository.save(participant);
        } catch (Exception e) {
            log.error("Error occurred while saving participant: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        log.info("Finished Participant created event: {}", participantCreatedEvent);
    }
}
