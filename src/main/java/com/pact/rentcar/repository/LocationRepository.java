package com.pact.rentcar.repository;


import com.pact.rentcar.model.Location;
import com.pact.rentcar.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findLocationById(Long Id);
}

