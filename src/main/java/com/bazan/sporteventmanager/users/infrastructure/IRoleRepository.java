package com.bazan.sporteventmanager.users.infrastructure;

import com.bazan.sporteventmanager.users.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IRoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
