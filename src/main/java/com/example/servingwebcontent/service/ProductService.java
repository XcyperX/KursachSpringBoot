package com.example.servingwebcontent.service;

import com.example.servingwebcontent.base.CRUDService;
import com.example.servingwebcontent.dto.ProductDto;

import java.util.List;

public interface ProductService extends CRUDService<ProductDto, Long> {
    List<ProductDto> findAll();
    List<ProductDto> findByStock(Long id);
}
