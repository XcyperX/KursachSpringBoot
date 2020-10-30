package com.example.servingwebcontent.models;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

import javax.persistence.*;
        import java.util.Set;

@Entity
@Table(name = "users")
@Data
//public class User implements UserDetails {
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id", nullable = false)
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;
}
