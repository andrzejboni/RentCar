package com.pact.rentcar.controller;

import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.dto.request.AddVehicleRequest;
import com.pact.rentcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicleForm")
    public String getvehicleFormPage(Model model) { // 04 3:20
        model.addAttribute("formObject", new AddVehicleRequest());
        return "admin/vehicleForm";
    }

    @PostMapping("/vehicleForm")
    public String sendVehicleForm(Model model, AddVehicleRequest addVehicleRequest) {
        // logika dodawania samochodu w panelu admina

        Optional<Vehicle> vehicleOptional = vehicleService.addVehicle(addVehicleRequest);
        if (vehicleOptional.isPresent()){
            return "redirect:/vehicleForm"; // Wywalic komunikat, albo przekierowac
        }

        model.addAttribute("message", "Could not add vehicle!");
        model.addAttribute("formObject", addVehicleRequest);

        return "admin/vehicleForm";
    }
//
//    @GetMapping
//    public String getVehicle


}
