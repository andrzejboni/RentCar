package com.pact.rentcar.controller;

import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.VehicleParameters;
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
    public String getBookingVehicle(Model model, @PathVariable(name = "vehicleId") Long id) {


        Vehicle vehicle = vehicleService.getVehicleByID(id);
        model.addAttribute("vehicles", vehicle);


        VehicleParameters vehicleParam = vehicleParametersService.getVehicleParametersByID(id);
        model.addAttribute("vehicleParameters", vehicleParam);



        return "user/booking";
    }


    // DO PORPAWKI @!!@
//    @GetMapping(path = "/user/booking/{vehicleId}")
//    public String getBookingVehicleParameters(Model model, @PathVariable(name = "vehicleId") Long id) {
//        VehicleParameters vehicleParam = vehicleParametersService.getVehicleParametersByID(id);
//
//        model.addAttribute("vehicleParameters", vehicleParam);
//
//        return "user/booking";
//    }



}