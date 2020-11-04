package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.models.User;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
public class UserDetailsServiceImpl {
    @Autowired
    private UserRepo userRepo;

    public Optional<User> loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
