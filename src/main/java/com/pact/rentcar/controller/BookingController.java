package com.pact.rentcar.controller;

import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.VehicleParameters;
import com.pact.rentcar.model.dto.request.AddBookingRequest;

import com.pact.rentcar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookingController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleParametersService vehicleParametersService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserAuthenticationService appUserAuthenticationService;
    @Autowired
    private BookingService bookingService;

    @ModelAttribute("loggedIn")
    public boolean getIsLoggedIn() {
        return appUserAuthenticationService.getLoggedInUser().isPresent();
    }


    @GetMapping(path = "/user/booking/{vehicleId}")
    public String getBookedVehicle(Model model, @PathVariable(name = "vehicleId") Long id) {
        model.addAttribute("formObject", new AddBookingRequest());

        Vehicle vehicle = vehicleService.getVehicleByID(id);
        model.addAttribute("vehicles", vehicle);

        VehicleParameters vehicleParam = vehicleParametersService.getVehicleParametersByID(id);
        model.addAttribute("vehicleParameters", vehicleParam);

        return "user/booking";
    }

    @PostMapping("/user/booking/{vehicleId}")
    public String sendBooking(Model model, @PathVariable(name = "vehicleId") Long id, AddBookingRequest request) {

        Optional<Booking> bookingOptional = bookingService.addBooking(request);
        if (bookingOptional.isPresent()) {
            return "redirect:/user/profile";
        }

        model.addAttribute("message", "Unable to book!");
        model.addAttribute("formObject", request);

        return "user/profile";
    }


//    @GetMapping(path = "/adminPanel")

    @GetMapping(path = "/profile") // FIXME przesnieśc do klasy ProfileController?
    public String getAllUserBookings(Model model) {
        List<Booking> bookingsList = bookingService.getAllBookings();  // FIXME tutaj powinna być metoda getAllBookingsByAppUserID() !!!

        model.addAttribute("bookings", bookingsList);

//        return "admin/adminPanel";
        return "user/booking";
    }


}