package com.example.travelagency.controllers;

import com.example.travelagency.requests.SearchRequest;
import com.example.travelagency.services.CountryService;
import com.example.travelagency.services.UserService;
import com.example.travelagency.services.VacationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    private final VacationService vacationService;
    private final CountryService countryService;
    private final UserService userService;

    public DashboardController(VacationService vacationService, CountryService countryService, UserService userService) {
        this.vacationService = vacationService;
        this.countryService = countryService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String getDashboardPage(Model model, Authentication authentication) {
        var vacations = vacationService.getAll();
        try {
            var user = userService.findByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
            model.addAttribute("user",user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("popular", vacations);
        model.addAttribute("search", new SearchRequest());


        return "dashboard";
    }

    @PostMapping("/dashboard/search")
    public String getSearchWindow(Model model, @ModelAttribute("search") SearchRequest searchRequest) {
        var list = vacationService.searchInput(searchRequest.getName());
        model.addAttribute("searchResult", list);
        return "search";
    }
    @GetMapping("/dashboard/slovakia")
        public String getEgypt(Model model, @ModelAttribute("search") SearchRequest searchRequest){
        var listOfSlovakia = vacationService.getAllSlovakia();
        model.addAttribute("slovakia", listOfSlovakia);

        var list = vacationService.searchInput(searchRequest.getName());
        model.addAttribute("searchResult", list);

        return "slovakia";
        }





}
