package com.example.servingwebcontent.mappers;

import com.example.servingwebcontent.dto.ProductDto;
import com.example.servingwebcontent.dto.RoleDto;
import com.example.servingwebcontent.dto.StockDto;
import com.example.servingwebcontent.dto.UserDto;
import com.example.servingwebcontent.models.Product;
import com.example.servingwebcontent.models.Role;
import com.example.servingwebcontent.models.Stock;
import com.example.servingwebcontent.models.User;
import org.springframework.stereotype.Component;

@Component
public class AllMapper {
    public User userDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        Stock stock = new Stock();
        stock.setId(userDto.getStockId());
        user.setStock(stock);
        Role role = new Role();
        role.setId(userDto.getRoleId());
        user.setRole(role);
        return user;
    }

    public UserDto entityToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setStockId(user.getStock().getId());
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }

    public Stock stockDtoToEntity(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setId(stockDto.getStockId());
        stock.setName(stockDto.getStockName());

        return stock;
    }

    public StockDto entityToStockDto(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setStockId(stock.getId());
        stockDto.setStockName(stock.getName());
        return stockDto;
    }

    public Product productDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getProductId());
        product.setNameProduct(productDto.getNameProduct());
        product.setAmountOnStock(productDto.getAmountOnStock());
        product.setAmountOnSale(productDto.getAmountOnSale());
        Stock stock = new Stock();
        stock.setId(productDto.getStockId());
        product.setStock(stock);
        product.setPriceProduct(productDto.getPriceProduct());
        return product;
    }

    public ProductDto entityToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setNameProduct(product.getNameProduct());
        productDto.setAmountOnStock(product.getAmountOnStock());
        productDto.setAmountOnSale(product.getAmountOnSale());
        productDto.setStockId(product.getStock().getId());
        productDto.setPriceProduct(product.getPriceProduct());
        return productDto;
    }

    public Role roleDtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getRoleId());
        role.setName(roleDto.getName());
        return role;
    }

    public RoleDto entityToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
