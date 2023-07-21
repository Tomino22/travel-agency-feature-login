package com.example.travelagency.controllers;

import com.example.travelagency.dtos.LoginDto;
import com.example.travelagency.dtos.RegisterDto;
import com.example.travelagency.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam("error") Optional<String> error) {
        var loginDto = new LoginDto();

        model.addAttribute("login", loginDto);

        if (error.isPresent()) {
            model.addAttribute("message", "Invalid password or email");
        }

        return "login";
    }



    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        var registerDto = new RegisterDto();

        model.addAttribute("user", registerDto);

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid RegisterDto registerDto,
                               Model model,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.register(registerDto);
        } catch (Exception e) {
            model.addAttribute("message", "This email is already registered");

            return "register";
        }

        return "redirect:/login";
    }

}
