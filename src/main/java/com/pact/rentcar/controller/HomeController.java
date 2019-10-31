package com.pact.rentcar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String hello(@RequestParam(defaultValue = "Ciastka155") String search, Model model) {
        return "resultPage";
    }

}
