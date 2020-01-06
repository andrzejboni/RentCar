package com.pact.rentcar.controller;

import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.dto.request.AddVehicleRequest;
import com.pact.rentcar.service.AppUserAuthenticationService;
import com.pact.rentcar.service.AppUserService;
import com.pact.rentcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserAuthenticationService appUserAuthenticationService;

    @ModelAttribute("loggedIn")       // TODO przenieść do appUserController
    public boolean getIsLoggedIn() {
        return appUserAuthenticationService.getLoggedInUser().isPresent();
    }

    @GetMapping(path = "/vehicles")
    public String getAllVehicles(Model model) {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();

        model.addAttribute("vehicles", vehicleList);

        return "vehicles";
    }





}
