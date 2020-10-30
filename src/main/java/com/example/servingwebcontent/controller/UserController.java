//package com.example.servingwebcontent.controller;
//
//import com.example.servingwebcontent.dto.UserDto;
//import com.example.servingwebcontent.repos.UserRepo;
//import com.example.servingwebcontent.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/users")
////@PreAuthorize("hasAuthority('ADMIN')")
//public class UserController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserRepo userRepo;
//
//
//    @GetMapping
//    public String userList(Model model) {
//        model.addAttribute("users", userRepo.findAll());
//        return "userList";
//    }
////
////    @GetMapping("{user}")
////    public String userEditForm(@PathVariable User user, Model model) {
////        Iterable<Stock> stocks = stockRepo.findAll();
////        model.addAttribute("user", user);
////        model.addAttribute("roles", Role.values());
////        model.addAttribute("stocks", stocks);
////
////        return "userEdit";
////    }
//
//    @PostMapping
//    public UserDto userSave(@RequestBody UserDto userDto) {
//        return userService.save(userDto);
//    }
//
//    @PutMapping("/{id}")
//    public UserDto userSave(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
//        userDto.setUserId(id);
//        return userService.update(userDto);
//    }
//}
