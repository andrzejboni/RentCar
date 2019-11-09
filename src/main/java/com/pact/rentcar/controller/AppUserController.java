package com.pact.rentcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user/")
public class AppUserController {

    @GetMapping(path = "/profile") // 03/28:22
    public String getProfile(){
        return "user/profile";
    }

}
