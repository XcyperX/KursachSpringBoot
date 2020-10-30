package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.dto.RoleDto;
import com.example.servingwebcontent.mappers.AllMapper;
import com.example.servingwebcontent.models.Role;
import com.example.servingwebcontent.repos.RoleRepo;
import com.example.servingwebcontent.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private AllMapper allMapper;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<RoleDto> findAll() {
        List<RoleDto> roleDtoList = new ArrayList<>();
        roleRepo.findAll().forEach(role -> roleDtoList.add(allMapper.entityToRoleDto(role)));
        return roleDtoList;
    }

    @Override
    public RoleDto getById(Long id) {
        Optional<Role> roleDtoOptional = roleRepo.findById(id);
        if (roleDtoOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой роли");
        }
        return allMapper.entityToRoleDto(roleDtoOptional.get());
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = allMapper.roleDtoToEntity(roleDto);
        return allMapper.entityToRoleDto(roleRepo.save(role));
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        Optional<Role> roleOptional = roleRepo.findById(roleDto.getRoleId());
        if (roleOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого склада");
        }
        Role role = allMapper.roleDtoToEntity(roleDto);
        return allMapper.entityToRoleDto(roleRepo.save(role));
    }

    @Override
    public void delete(Long id) {
        Optional<Role> roleOptional = roleRepo.findById(id);
        if (roleOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого склада");
        }
        roleRepo.deleteById(id);
    }
}
