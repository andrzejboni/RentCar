package com.pact.rentcar.controller;

import com.pact.rentcar.model.*;
import com.pact.rentcar.model.dto.request.AddBookingRequest;
import com.pact.rentcar.repository.VehicleStatusRepository;
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
    @Autowired
    private VehicleStatusService vehicleStatusService;


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

        // UWAGA
        AppUser appUser = appUserService.findUserByUsername(appUserService.getLoggedUsername()); // pobieram ID zalogowanego uzytkownika do przypisanego bookowania.
        model.addAttribute("appUsers", appUser);
        //

        return "user/booking";
    }


    @PostMapping(path = "/user/booking/{vehicleId}")
    public String sendBooking(Model model, @PathVariable(name = "vehicleId") Long id, AddBookingRequest request) {
        Optional<Booking> bookingOptional = bookingService.addBooking(request);

        vehicleStatusService.updateVehicleStatus(id, false); // Aktualizje status pojazdu po zabookowaniu

        model.addAttribute("formObject", request);

        return "index";
    }


}