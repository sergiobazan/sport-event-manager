package com.bazan.sporteventmanager.events.domain.events;

import com.bazan.sporteventmanager.events.domain.participants.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "events", schema = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventStatus status;
    private EventType type;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_teams",
            schema = "events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    @JsonBackReference
    private List<Team> teams = new ArrayList<>();
}
