package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.ProductDto;
import com.example.servingwebcontent.dto.StockDto;
import com.example.servingwebcontent.models.Role;
import com.example.servingwebcontent.models.User;
import com.example.servingwebcontent.report.PDFGenerator;
import com.example.servingwebcontent.service.ProductService;
import com.example.servingwebcontent.service.RoleService;
import com.example.servingwebcontent.service.StockService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

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
    public String getProducts(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.findByStock(user.getStock().getId()));
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

//    @GetMapping("/reports")
//    public String getReports(Model model) {
//        model.addAttribute("users", userService.findAll());
//        model.addAttribute("stocks", stockService.findAll());
//        model.addAttribute("products", productService.findAll());
//        return "reports";
//    }

    @GetMapping("/reports/stocks")
    public String getAllReports(Model model, @RequestParam Long stockId) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("stocks", stockService.findAll());
        model.addAttribute("products", productService.findByStock(stockId));
        return "reports";
    }

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping(value = "/api/pdf/products", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customersReport() throws IOException {
        List<ProductDto> productDtoList = productService.findAll();
        List<StockDto> stockDtoList = stockService.findAll();
        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(productDtoList, stockDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=products.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
