package com.pact.rentcar.repository;

import com.pact.rentcar.model.Location;
import com.pact.rentcar.model.VehicleParameters;
import com.pact.rentcar.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
    Optional<VehicleStatus> findByVehicleStatCode(String vehicleStatCode);



}
