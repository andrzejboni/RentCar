package com.pact.rentcar.controller;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.dto.request.RegisterUserRequest;
import com.pact.rentcar.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthorizationController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "authorization/login"; // 03/14:44
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) { // 04 3:20
        model.addAttribute("formObject", new RegisterUserRequest());

        return "authorization/register";
    }

    @PostMapping("/register")
    public String sendRegister(Model model, RegisterUserRequest request) {
        // logika rejsetstracji

        Optional<AppUser> appUserOptional = appUserService.register(request);
        if (appUserOptional.isPresent()) {
            return "redirect:/login";
        }

        model.addAttribute("message", "Could not register!");
        model.addAttribute("formObject", request);

        return "authorization/register";
    }


}
