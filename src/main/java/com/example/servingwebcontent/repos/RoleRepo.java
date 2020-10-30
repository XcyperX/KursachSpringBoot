package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
