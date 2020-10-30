package com.example.servingwebcontent.service;

import com.example.servingwebcontent.base.CRUDService;
import com.example.servingwebcontent.dto.RoleDto;

import java.util.List;

public interface RoleService extends CRUDService<RoleDto, Long> {
    List<RoleDto> findAll();
}
