package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.mappers.AllMapper;
import com.example.servingwebcontent.models.Product;
import com.example.servingwebcontent.dto.ProductDto;
import com.example.servingwebcontent.repos.ProductRepo;
import com.example.servingwebcontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private AllMapper allMapper;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto getById(Long aLong) {
        return null;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = allMapper.productDtoToEntity(productDto);
        return allMapper.entityToProductDto(productRepo.save(product));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Optional<Product> productOptional = productRepo.findById(productDto.getProductId());
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого товара!");
        }
        Product product = allMapper.productDtoToEntity(productDto);
        return allMapper.entityToProductDto(productRepo.save(product));
    }

    @Override
    public void delete(Long aLong) {

    }
}
