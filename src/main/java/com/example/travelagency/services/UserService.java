package com.example.travelagency.services;

import com.example.travelagency.dtos.RegisterDto;
import com.example.travelagency.entities.UserEntity;

public interface UserService {

    void register (RegisterDto registerDto) throws Exception;
    UserEntity findByEmail (String email) throws Exception;
}
