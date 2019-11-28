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

//    @GetMapping(path = "/pizzaForm")
//    public String getPizzaForm(Model model) {
//        model.addAttribute("formObject", new AddPizzaRequest());
//
//        return "admin/pizzaForm";
//    }
//
//    @PostMapping(path = "/pizzaForm")
//    public String sendNewPizza(Model model, AddPizzaRequest request) {
//        Optional<Pizza> pizzaOptional = pizzaService.addPizza(request);
//        if (pizzaOptional.isPresent()) {
//            Pizza createdPizza = pizzaOptional.get();
//
//            return "redirect:/admin/ingredients/" + createdPizza.getId();
//        }
//
//        model.addAttribute("message", "Could not add pizza!");
//        model.addAttribute("formObject", request);
//
//        return "admin/pizzaForm";
//    }
//
//    @GetMapping(path = "/ingredients/{id}")
//    public String getIngredientsForm(Model model, @PathVariable(name = "id") Long id) {
//        IngredientsRequest request = new IngredientsRequest();
//        request.setPizzaId(id);
//        request.setIngredients(pizzaService.getAllIngredients()
//                .stream()
//                .map(ingredient -> new IngredientRequest(ingredient.getName(), false))
//                .collect(Collectors.toList()));
//
//        model.addAttribute("formObject", request);
//
//        return "admin/ingredientsForm";
//    }
//
//    @PostMapping(path = "/ingredients/{id}")
//    public String sendIngredients(Model model, IngredientsRequest request) {
//        Optional<Pizza> pizza = pizzaService.updateIngredients(request);
//        return "redirect:/pizzas";
//    }


}
