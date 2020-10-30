package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepo extends JpaRepository<Stock, Long> {
}
