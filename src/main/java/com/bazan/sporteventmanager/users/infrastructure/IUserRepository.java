package com.bazan.sporteventmanager.users.infrastructure;

import com.bazan.sporteventmanager.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
}
