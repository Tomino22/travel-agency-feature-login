package com.example.travelagency.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class RegisterDto {

        @NotEmpty(message = "This label cannot be empty.")
        private String email;

        @NotEmpty(message = "This label cannot be empty.")
        private String password;

        @NotEmpty(message = "This label cannot be empty.")
        private String firstName;

        @NotEmpty(message = "This label cannot be empty.")
        private String lastName;
}
