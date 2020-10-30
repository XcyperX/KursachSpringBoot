package com.example.servingwebcontent.service;

import com.example.servingwebcontent.base.CRUDService;
import com.example.servingwebcontent.dto.StockDto;

import java.util.List;

public interface StockService extends CRUDService<StockDto, Long> {
    List<StockDto> findAll();
}
