package com.example.travelagency.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "admin")
    private boolean isAdmin = false;



}
