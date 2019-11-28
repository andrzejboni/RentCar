package com.pact.rentcar.controller;


import com.pact.rentcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@RequestMapping(path = "/admin/")
public class AdminController {


    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "/adminPanel")
    public String getAdmin(){
        return "admin/adminPanel";
    }



}
