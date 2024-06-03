package com.example.bike_commerce.controllers;

import com.example.bike_commerce.customers.entities.Customer;
import com.example.bike_commerce.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    CustomersService customersService;

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @PostMapping("/login")
    public String postLoginData() {

        return "redirect:/dashboard";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("service_user", new Customer());

        return "/auth/signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("service_user", customer);
        customersService.createUser(customer);

        return "redirect:/login";
    }


}
