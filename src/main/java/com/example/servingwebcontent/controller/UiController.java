package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.models.Role;
import com.example.servingwebcontent.service.ProductService;
import com.example.servingwebcontent.service.RoleService;
import com.example.servingwebcontent.service.StockService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UiController {
    @Autowired
    private StockService stockService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ProductService productService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "registration";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        return "userList";
    }

    @GetMapping("/users/{id}")
    public String userEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        return "userEdit";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.findAll());
        return "stock";
    }

    @GetMapping("/products/items")
    public String getProduct(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.findAll());
        return "addProduct";
    }

    @GetMapping("/products/items/{id}")
    public String getProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.getById(id));
        return "productEdit";
    }

//    @GetMapping("/products/all")
//    public String getAllProduct(Model model) {
//        model.addAttribute("users", userService.findAll());
//        model.addAttribute("stocks", stockService.findAll());
//        model.addAttribute("products", productService.findAll());
//        return "allStock";
//    }
//
//    @GetMapping("/products/all/stock/{id}")
//    public String getProductOnStock(@PathVariable("id") Long id,Model model) {
//        model.addAttribute("users", userService.findAll());
//        model.addAttribute("stocks", stockService.findAll());
//        model.addAttribute("products", productService.findByStock(id));
//        return "allStock";
//    }

    @GetMapping("/products/stocks")
    public String getAllProduct(Model model, @RequestParam Long stockId) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.findByStock(stockId));
        return "allStock";
    }

    @GetMapping("/supplier")
    public String getSupplier(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.findAll());
        return "supplier";
    }
}
