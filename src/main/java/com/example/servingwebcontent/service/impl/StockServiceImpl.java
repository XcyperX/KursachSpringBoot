package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.mappers.AllMapper;
import com.example.servingwebcontent.models.Stock;
import com.example.servingwebcontent.dto.StockDto;
import com.example.servingwebcontent.repos.StockRepo;
import com.example.servingwebcontent.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private AllMapper allMapper;
    @Autowired
    private StockRepo stockRepo;

    @Override
    public StockDto save(StockDto stockDto) {
        Stock stock = allMapper.stockDtoToEntity(stockDto);
        return allMapper.entityToStockDto(stockRepo.save(stock));
    }

    @Override
    public StockDto update(StockDto stockDto) {
        Optional<Stock> stockOptional = stockRepo.findById(stockDto.getStockId());
        if (stockOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого склада!");
        }
        Stock stock = allMapper.stockDtoToEntity(stockDto);
        return allMapper.entityToStockDto(stockRepo.save(stock));
    }

    @Override
    public List<StockDto> findAll() {
        List<StockDto> stockDtoList = new ArrayList<>();
        stockRepo.findAll().forEach(stock -> stockDtoList.add(allMapper.entityToStockDto(stock)));
        return stockDtoList;
    }

    @Override
    public StockDto getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Stock> stockOptional = stockRepo.findById(id);
        if (stockOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого склада!");
        }
        stockRepo.deleteById(id);
    }
}
