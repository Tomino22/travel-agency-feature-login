package com.example.travelagency.controllers;

import com.example.travelagency.dtos.NumberDto;
import com.example.travelagency.requests.SearchRequest;
import com.example.travelagency.services.VacationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    private final VacationService vacationService;

    public DashboardController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/dashboard")
    public String getDashboardPage(Model model) {
        var vacations = vacationService.getAll();
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




}
