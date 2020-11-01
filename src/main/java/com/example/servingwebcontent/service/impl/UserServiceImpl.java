package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.mappers.AllMapper;
import com.example.servingwebcontent.models.User;
import com.example.servingwebcontent.dto.UserDto;
import com.example.servingwebcontent.repos.UserRepo;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AllMapper allMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto save(UserDto userDto) {
        User user = allMapper.userDtoToEntity(userDto);
        return allMapper.entityToUserDto(userRepo.save(user));
    }

    @Override
    public UserDto update(UserDto userDto) {
        Optional<User> userOptional = userRepo.findById(userDto.getUserId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого пользователя!");
        }
        User user = allMapper.userDtoToEntity(userDto);
        return allMapper.entityToUserDto(userRepo.save(user));
    }

    @Override
    public UserDto getById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого пользователя!");
        }
        return allMapper.entityToUserDto(user.get());
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого пользователя!");
        }
        userRepo.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();
        userRepo.findAll().forEach(user -> userDtos.add(allMapper.entityToUserDto(user)));
        return userDtos;
    }


}
