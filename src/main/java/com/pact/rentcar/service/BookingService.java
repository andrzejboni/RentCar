package com.pact.rentcar.service;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.dto.request.AddBookingRequest;
import com.pact.rentcar.repository.BookingRepository;
import com.pact.rentcar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Optional<Booking> addBooking(AddBookingRequest addBookingRequest) {
        Optional<Booking> optionalBooking = bookingRepository.findByVehicle(addBookingRequest.getVehicle());// FIXME
        if (!optionalBooking.isPresent()) {
            Booking booking = new Booking();

            booking.setRecipeDate(addBookingRequest.getRecipeDate());
            booking.setReturnDate(addBookingRequest.getReturnDate());
            booking.setTotalCost(addBookingRequest.getTotalCost());
            booking.setAppUser(addBookingRequest.getAppUser());
            booking.setLocation(addBookingRequest.getLocation());
            booking.setVehicle(addBookingRequest.getVehicle());

            return Optional.of(bookingRepository.save(booking));
        }
        return Optional.empty();
    }

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }


    public List<Booking> findAllBookingsByUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName(); // Pobieram username zalogowanego użytkownika

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        List<Booking> allBookings = bookingRepository.findAll();
        List<Booking> userBookings = new ArrayList<>();

        for (Booking p : allBookings) {
            if ((p.getAppUser().getUsername()).equals(currentPrincipalName)) {
                userBookings.add(p);
//                break;
            }
        }

        return userBookings;
    }




}
