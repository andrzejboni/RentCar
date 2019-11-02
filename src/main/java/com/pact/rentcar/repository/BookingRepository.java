package com.pact.rentcar.repository;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
