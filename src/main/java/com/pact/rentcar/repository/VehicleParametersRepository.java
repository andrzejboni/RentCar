package com.pact.rentcar.repository;


import com.pact.rentcar.model.Stars;
import com.pact.rentcar.model.VehicleParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleParametersRepository extends JpaRepository<VehicleParameters, Long> {
    Optional<VehicleParametersRepository> findByVehicleID(Long vehicleID);


}
