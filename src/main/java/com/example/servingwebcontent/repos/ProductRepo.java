package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByStockId(Long stockId);
}
