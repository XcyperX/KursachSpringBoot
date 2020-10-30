package com.example.servingwebcontent.service;

import com.example.servingwebcontent.base.CRUDService;
import com.example.servingwebcontent.dto.UserDto;

import java.util.List;

public interface UserService extends CRUDService<UserDto, Long>{
    List<UserDto> findAll();
}
