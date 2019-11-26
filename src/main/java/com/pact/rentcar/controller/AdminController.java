package com.pact.rentcar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/admin/")
public class AdminController {

    @GetMapping(path = "/adminPanel")
    public String getAdmin(){
        return "admin/adminPanel";
    }

}
