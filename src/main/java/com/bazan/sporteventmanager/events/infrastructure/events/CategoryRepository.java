package com.bazan.sporteventmanager.events.infrastructure.events;

import com.bazan.sporteventmanager.events.domain.events.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
