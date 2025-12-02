package com.rw.cok.user_service.repositories;

import com.rw.cok.user_service.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRoleRepository extends JpaRepository<Role, UUID> {
}
