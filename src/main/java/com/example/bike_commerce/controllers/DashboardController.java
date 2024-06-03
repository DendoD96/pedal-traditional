package com.example.bike_commerce.controllers;

import com.example.bike_commerce.configuration.UserInfoUserDetails;
import com.example.bike_commerce.customers.entities.Order;
import com.example.bike_commerce.customers.repositories.OrderRepository;
import com.example.bike_commerce.employees.entities.Employees;
import com.example.bike_commerce.services.CustomersService;
import com.example.bike_commerce.services.EmployeesService;
import com.example.bike_commerce.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    EmployeesService employeesService;
    private static final Logger log = LoggerFactory.getLogger(redhat.engineering.ebikes.controller.BikeController.class);

    @Autowired
    CustomersService customersService;

    @Autowired
    OrderService orderService;

    @GetMapping("/dashboard/customers")
    public String customers(Model model) {
        model.addAttribute("service_users", customersService.retrieveUsers("CUSTOMERS"));

        return "users";
    }

    @GetMapping("/dashboard/employees")
    public String employees(Model model) {
        model.addAttribute("employees", employeesService.retrieveAllEmployees());

        return "dashboard/employees";
    }

    @GetMapping("/dashboard/add-employee")
    public String addEmployee(Model model) {
        model.addAttribute("employees", new Employees());

        return "dashboard/add-employee";
    }

    @PostMapping("/dashboard/insert-employee")
    public String insertEmployee(@ModelAttribute Employees employeeData, Model model) {
        model.addAttribute("employees", employeesService);
        employeesService.createEmployee(employeeData);

        return "redirect:/dashboard/employees";
    }

    @GetMapping("/dashboard/profile")
    public String profile(@AuthenticationPrincipal UserInfoUserDetails user, Model model) {
        List<Order> orders = orderService.getOrdersForUser(user.getId());
        model.addAttribute("orders", orders);

        return "/dashboard/profile";
    }
}
