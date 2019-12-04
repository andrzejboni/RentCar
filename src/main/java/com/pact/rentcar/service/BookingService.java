package com.pact.rentcar.service;
import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.dto.request.AddBookingRequest;
import com.pact.rentcar.repository.BookingRepository;
import com.pact.rentcar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Autowired
    private VehicleRepository vehicleRepository;


//    public Optional<Booking> addBooking(AddBookingRequest addBookingRequest) {
//        Optional<Booking> optionalBooking = bookingRepository.findByVehicle(addBookingRequest.getVehicle());
//        if (!optionalBooking.isPresent()) {
//            Booking booking = new Booking();
//
//            booking.setRecipeDate(addBookingRequest.getRecipeDate());
//            booking.setReturnDate(addBookingRequest.getReturnDate());
//            booking.setTotalCost(addBookingRequest.getTotalCost());
//            booking.setAppUser(addBookingRequest.getAppUser());
//            booking.setLocation(addBookingRequest.getLocation());
//            booking.setVehicle(addBookingRequest.getVehicle());
//
//            return Optional.of(bookingRepository.save(booking));
//        }
//        return Optional.empty();
//    }

    public Optional<Booking> addBooking(AddBookingRequest addBookingRequest) {
        Optional<Booking> optionalBooking = bookingRepository.findByVehicle(addBookingRequest.getVehicle());
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

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findAllByAppUserId(AppUser appUser){ // FIXME to moze nie zadziałać
        return bookingRepository.findAllByAppUserId(appUser);
    }

}
