package com.pact.rentcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndex(){
        return "index"; // zwrócimy index.html w templates

    }

    @GetMapping("/cars")
    public String getCars(){
        return "cars";

    }



}
