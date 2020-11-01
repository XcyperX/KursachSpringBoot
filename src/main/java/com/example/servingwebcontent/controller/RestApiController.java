package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.ProductDto;
import com.example.servingwebcontent.dto.RoleDto;
import com.example.servingwebcontent.dto.StockDto;
import com.example.servingwebcontent.dto.UserDto;
import com.example.servingwebcontent.service.ProductService;
import com.example.servingwebcontent.service.RoleService;
import com.example.servingwebcontent.service.StockService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private StockService stockService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ProductService productService;

    @PostMapping("/users")
    public UserDto userSave(@RequestBody @Valid UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/users/{id}")
    public UserDto userSave(@PathVariable("id") Long id, @RequestBody @Valid UserDto userDto) {
        userDto.setUserId(id);
        return userService.update(userDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PostMapping("/stocks")
    public StockDto addStock(@RequestBody @Valid StockDto stockDto) {
        return stockService.save(stockDto);
    }
//
    @PutMapping("/stocks/{id}")
    public StockDto addStock(@PathVariable("id") Long id, @RequestBody @Valid StockDto stockDto) {
        stockDto.setStockId(id);
        return stockService.update(stockDto);
    }

    @PostMapping("/roles")
    public RoleDto addStock(@RequestBody @Valid RoleDto roleDto) {
        return roleService.save(roleDto);
    }

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.save(productDto);
    }

    @PutMapping("/products/items/{id}")
    public ProductDto userSave(@PathVariable("id") Long id, @RequestBody @Valid ProductDto productDto) {
        productDto.setProductId(id);
        return productService.update(productDto);
    }

    @DeleteMapping("/products/items/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
