package com.pact.rentcar.repository;

import com.pact.rentcar.model.ChangesBooking;
import com.pact.rentcar.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {

}

