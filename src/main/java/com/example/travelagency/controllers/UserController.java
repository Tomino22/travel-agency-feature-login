package com.example.travelagency.controllers;

import com.example.travelagency.entities.BookingEntity;
import com.example.travelagency.repositories.TermRepository;
import com.example.travelagency.services.BookingService;
import com.example.travelagency.services.UserService;
import com.example.travelagency.services.VacationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;
    private final VacationService vacationService;
    private final BookingService bookingService;
    private final TermRepository termRepository;


    public UserController(UserService userService, TermRepository termRepository, VacationService vacationService, BookingService bookingService) {
        this.userService = userService;
        this.vacationService = vacationService;
        this.bookingService = bookingService;
        this.termRepository = termRepository;
    }

    @GetMapping("/user/{userId}/book")
    public String getUserBooks(Model model,
                               @PathVariable("userId") Long userId,
                               Authentication authentication) {
        try {
            var user = userService.findByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
            var book = bookingService.getUserBooks(userId);
            var termEntities = book.stream()
                    .map(BookingEntity::getTermEntity)
                    .collect(Collectors.toList());

//            var vacation = vacationService.get

            model.addAttribute("user", user);
            model.addAttribute("book", book);
            model.addAttribute("termEntities", termEntities);
//            model.addAttribute("vacation", vacation);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "user";


    }
}
