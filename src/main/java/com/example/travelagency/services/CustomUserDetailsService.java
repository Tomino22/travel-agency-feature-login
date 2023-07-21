package com.example.travelagency.services;

import com.example.travelagency.entities.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    public CustomUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            var user = userService.findByEmail(email);
            System.out.println("Found user: " + user.getEmail());
            return buildUserForAuthentication(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }

    }

    private UserDetails buildUserForAuthentication(UserEntity user) {
        String[] roles;
        if (user.isAdmin()) {
           roles = new String[]{ "USER", "ADMIN"};
        } else {
            roles = new String[]{ "USER"};
        }
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }

}