package com.pact.rentcar.repository;


import com.pact.rentcar.model.ChangesBooking;
import com.pact.rentcar.model.VehicleParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleParametersRepository extends JpaRepository<VehicleParameters, Long> {

}

