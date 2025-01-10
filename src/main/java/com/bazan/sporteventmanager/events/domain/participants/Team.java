package com.bazan.sporteventmanager.events.domain.participants;

import com.bazan.sporteventmanager.events.domain.events.Event;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "teams", schema = "events")
public class Team {
    @Id
    private UUID id;

    private String name;
    private String description;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Participant> members = new ArrayList<>();

    @ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Event> events = new ArrayList<>();
}
