package com.pact.rentcar.repository;

import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.ChangesBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangesBookingRepository extends JpaRepository<ChangesBooking, Long> {

}
