package com.pact.rentcar.controller;

import com.pact.rentcar.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SimpleController { // FIXME wyłącznie do testów (do usunięcia)

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/helloworld")
    @ResponseBody
    public String helloWorld() {
        return "Hello " + helloService.getHello() + "!";
    }
}
