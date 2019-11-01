package com.pact.rentcar.repository;

import com.pact.rentcar.model.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<AppUserRole, Long> {

    Optional<AppUserRole> findByName(String name);
}