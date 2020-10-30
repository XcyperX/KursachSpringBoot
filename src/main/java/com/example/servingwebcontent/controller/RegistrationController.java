//package com.example.servingwebcontent.controller;
//
//import com.example.servingwebcontent.models.Role;
//import com.example.servingwebcontent.models.User;
//import com.example.servingwebcontent.repos.StockRepo;
//import com.example.servingwebcontent.repos.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.Collections;
//import java.util.Map;
//import java.util.Optional;
//
//@Controller
//public class RegistrationController {
//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private StockRepo stockRepo;
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("stocks", stockRepo.findAll());
//        model.addAttribute("roles", Role.values());
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(User user, Map<String, Object> model) {
//        Optional<User> userFromDb = userRepo.findByUsername(user.getUsername());
//
//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//
//        user.setRoles(Collections.singleton(Role.USER));
//        userRepo.save(user);
//
//        return "redirect:/login";
//    }
//}
