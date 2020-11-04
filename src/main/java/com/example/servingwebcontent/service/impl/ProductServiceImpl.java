package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.mappers.AllMapper;
import com.example.servingwebcontent.models.Product;
import com.example.servingwebcontent.dto.ProductDto;
import com.example.servingwebcontent.repos.ProductRepo;
import com.example.servingwebcontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private AllMapper allMapper;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto getById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого товара!");
        }
        return allMapper.entityToProductDto(productOptional.get());
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
    public void delete(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого товара!");
        }
        productRepo.deleteById(id);
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepo.findAll().forEach(product -> productDtoList.add(allMapper.entityToProductDto(product)));
        return productDtoList;
    }

    @Override
    public List<ProductDto> findByStock(Long id) {
        if (id == 0 || id == null) {
            return allMapper.entityToProductDto(productRepo.findAll());
        }
        return allMapper.entityToProductDto(productRepo.findAllByStockId(id));
    }

    @Override
    public ProductDto setSupplierById(Long id, Integer amount) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого товара!");
        }
        productOptional.get().setOrderedSupplier(amount);
        return allMapper.entityToProductDto(productRepo.save(productOptional.get()));
    }
}
