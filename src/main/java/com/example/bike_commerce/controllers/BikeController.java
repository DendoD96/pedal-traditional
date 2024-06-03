package com.example.bike_commerce.controllers;

import com.example.bike_commerce.configuration.UserInfoUserDetails;
import com.example.bike_commerce.customers.entities.Bike;
import com.example.bike_commerce.services.BikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class BikeController {
    @Autowired
    BikeService bikeService;
    private static final Logger log = LoggerFactory.getLogger(redhat.engineering.ebikes.controller.BikeController.class);


    @GetMapping("/dashboard/bike/purchase")
    public String purchase(@RequestParam Long bikeId, Model model) {
        if (bikeService.retrieveABike(bikeId).isPresent()) {
            model.addAttribute("bike", bikeService.retrieveABike(bikeId));
            return "/order/purchase";
        }

        return "redirect:/dashboard";
    }

    @PostMapping("/purchase/{bikeId}")
    public String submitPurchase(@PathVariable Long bikeId , Model model) {
        UserInfoUserDetails userDetails = (UserInfoUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Bike> retrievedBike = bikeService.retrieveABike(bikeId);

        if (retrievedBike.isPresent()) {
            model.addAttribute("bike", retrievedBike);
            bikeService.purchaseBike(retrievedBike, userDetails.getId());
        }

        return "redirect:/";
    }

    @PostMapping("/dashboard/bike/insert-bike")
    public String postBikeAd(@ModelAttribute Bike bikeData, Model model) {
        model.addAttribute("bike", bikeData);
        bikeService.postBikeAd(bikeData);

        return "redirect:/dashboard";
    }

    @GetMapping("dashboard/bike/create-bike")
    public String createBike(Model model) {
        model.addAttribute("bike", new Bike());
        return "create-bike";
    }

    @GetMapping("dashboard/bike/edit")
    public String updateBike(@RequestParam Long id, Model model) {
        if (bikeService.retrieveABike(id).isPresent()) {
            model.addAttribute("bike_form", new Bike());
            model.addAttribute("bike", bikeService.retrieveABike(id));
            return "update-bike";
        }

        return "redirect:/dashboard";
    }

    @PostMapping("/bike/update")
    public String submitBikeUpdateForm(@RequestParam Long id, Model model) {
        if (bikeService.retrieveABike(id).isPresent()) {
            model.addAttribute("bike", bikeService.retrieveABike(id));
            return "update-bike";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/bike/delete/{bikeId}")
    public String deleteBike(@PathVariable Long bikeId, Model model) {
        Optional<Bike> singleBike = bikeService.retrieveABike(bikeId);

        singleBike.ifPresent(bike -> bikeService.deleteABike((Long) bike.getId()));

        return "redirect:/dashboard";
    }
}

