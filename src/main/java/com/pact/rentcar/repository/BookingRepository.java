package com.pact.rentcar.repository;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.UserRole;
import com.pact.rentcar.model.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByVehicle(Vehicle vehicle);

//    Optional<Booking> findByAppUserId( AppUser appUser);

//    Optional<Booking> findAllByAppUserId(AppUser appUser);

//    Optional<Booking> findAllByAppUserId(Long id);

    List<Booking> findAllByAppUserId(Long id);


}
