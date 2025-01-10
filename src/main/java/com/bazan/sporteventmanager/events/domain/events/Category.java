package com.bazan.sporteventmanager.events.domain.events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "categories", schema = "events")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonBackReference
    private List<Event> events;
}
