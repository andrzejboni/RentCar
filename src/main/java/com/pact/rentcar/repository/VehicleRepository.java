package com.pact.rentcar.repository;


import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findVehicleByRegistration(String registration);

}
