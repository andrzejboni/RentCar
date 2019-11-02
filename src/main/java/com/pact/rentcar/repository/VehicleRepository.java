package com.pact.rentcar.repository;


import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
