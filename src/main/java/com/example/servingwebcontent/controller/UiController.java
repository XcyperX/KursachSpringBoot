package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.models.Role;
import com.example.servingwebcontent.service.RoleService;
import com.example.servingwebcontent.service.StockService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    @Autowired
    private StockService stockService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "registration";
    }

    @GetMapping("/stock")
    public String stock(Model model) {
        model.addAttribute("stocks", stockService.findAll());
        return "stock";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        return "userList";
    }
}
