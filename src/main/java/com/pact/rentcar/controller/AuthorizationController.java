package com.pact.rentcar.controller;

import com.pact.rentcar.model.dto.request.RegisterUserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "authorization/login"; // 03/14:44
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model){ // 04 3:20
        model.addAttribute("formObject", new RegisterUserRequest());
                return "authorization/register";
    }

    @PostMapping


}
