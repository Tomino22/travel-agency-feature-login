package com.example.travelagency.services;

import com.example.travelagency.dtos.RegisterDto;
import com.example.travelagency.entities.UserEntity;
import com.example.travelagency.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    private String emailUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterDto registerDto) throws Exception {
        var user = new UserEntity();

        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

//        UserEntity.builder()
//                .firstName(registerDto.getFirstName())
//                .lastName(registerDto.getLastName())
//                .email(registerDto.getEmail())
//                .password(passwordEncoder.encode(registerDto.getPassword()))
//                .build();

        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow( () -> new Exception("User not found"));

    }
}
