package com.example.travelagency.controllers;

import com.example.travelagency.requests.VacationRequest;
import com.example.travelagency.services.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpServerErrorException;


@Controller
public class VacationController {

    private final VacationService vacationService;
    private final TermService termService;
    private final UserService userService;
    private final BookingService bookingService;

    public VacationController(VacationService vacationService, TermService termService, UserService userService, BookingService bookingService) {
        this.vacationService = vacationService;
        this.termService = termService;
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @GetMapping("/vacation")
    public String getAll(Model model) {
        var vacations = vacationService.getAll();
        model.addAttribute("vacations", vacations);

        var alphabetical = vacationService.getAllByNameAsc();
        model.addAttribute("alpha", alphabetical);

        return "vacation";
    }

    @GetMapping("/country")
    public String getVacationsByCountry(Model model, @Valid VacationRequest vacationRequest) {
        var vacation1 = vacationService.getVacationsByCountry(vacationRequest.getName());
        model.addAttribute("vacationsCountry", vacation1);
        return "country";
    }

    @GetMapping("vacation/{vacationId}/term")
    public String getTermsPage(Model model, @PathVariable("vacationId") Long vacationId) {

        var listOfTerms = termService.getAllTerms(vacationId);
        model.addAttribute("termList", listOfTerms);
        return "term";
    }

    @GetMapping("vacation/{vacationId}/{termId}/book")
    public String bookVacation(
            Model model,
            Authentication authentication,
            @PathVariable("vacationId") Long vacationId,
            @PathVariable("termId") Long termId) {
        try {
            var user = userService.findByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
            var book = bookingService.book(termId, user.getId());

            model.addAttribute("booking", book);
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return "term";
    }


}
