package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
