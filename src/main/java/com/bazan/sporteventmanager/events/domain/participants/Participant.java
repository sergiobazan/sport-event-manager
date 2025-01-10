package com.bazan.sporteventmanager.events.domain.participants;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "participants", schema = "events")
public class Participant {
    @Id
    private UUID id;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;
}
