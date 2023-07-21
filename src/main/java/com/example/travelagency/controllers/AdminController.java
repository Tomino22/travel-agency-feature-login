package com.example.travelagency.controllers;

import com.example.travelagency.entities.CountryEntity;
import com.example.travelagency.requests.DeleteRequest;
import com.example.travelagency.requests.UpdateRequest;
import com.example.travelagency.requests.VacationRequest;
import com.example.travelagency.services.CountryService;
import com.example.travelagency.services.VacationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private final VacationService vacationService;

    private final CountryService countryService;


    public AdminController(VacationService vacationService, CountryService countryService) {
        this.vacationService = vacationService;
        this.countryService = countryService;
    }

    @GetMapping("/admin/vacation/create")
    public String getCreatepage(Model model) throws Exception {
        var vacation = new VacationRequest();
        model.addAttribute("newVacation", vacation);

        Set<CountryEntity> listOfCountries = countryService.getAllCountryNames();
        model.addAttribute("countries", listOfCountries);

        return "creator";
    }

    @PostMapping("/admin/vacation/create")
    public String insertVacation(@ModelAttribute("newVacation") @Valid VacationRequest vacationRequest,
                                 BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "creator";
        }
        try {
            vacationService.insertVacation(vacationRequest);

        } catch (Exception e) {
            model.addAttribute("message", "Something went wrong.");
            return "redirect:/dashboard";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/admin/vacation/{vacationId}/update")
    public String getUpdatePage(Model model, @PathVariable("vacationId") long vacationId) {
        var toUpdate = new UpdateRequest();
        toUpdate.setId(vacationId);
        var vacation = vacationService.getVacationById(vacationId);
        toUpdate.setDestination(vacation.getDestination());
        toUpdate.setDescription(vacation.getDescription());
        toUpdate.setName(vacation.getName());
        toUpdate.setRoomType(vacation.getRoomType());
        toUpdate.setCountryId(vacation.getCountryEntity().getId());
        model.addAttribute("updateVacation", toUpdate);

        Set<CountryEntity> countryList;
        try {
            countryList = countryService.getAllCountryNames();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("countries", countryList);
        return "update";
    }


    @PostMapping("/admin/vacation/{vacationId}/update")
    public String update(@PathVariable("vacationId") Long vacationId, @ModelAttribute("updateVacation") @Valid UpdateRequest updateRequest,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        vacationService.updateVacation(vacationId, updateRequest);
        return "redirect:/vacation";
    }

    @GetMapping("/admin/vacation/{vacationId}/delete")
    public String getDeletePage(Model model, @PathVariable("vacationId") Long vacationId) {
        var delete = new DeleteRequest();
        delete.setId(vacationId);
        model.addAttribute("deleteVacation", delete);
        return "delete";
    }

    @PostMapping("/admin/vacation/{vacationId}/delete")
    public String update(@PathVariable("vacationId") Long vacationId, @ModelAttribute("deleteVacation") @Valid DeleteRequest deleteRequest,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "delete";
        }
        vacationService.deleteVacationById(vacationId);
        return "redirect:/vacation";
    }

    @GetMapping("/admin/dashboard")
    public String getAdminPage (Model model) {
        var vacations = vacationService.getAll();
        model.addAttribute("vacations", vacations);

        return "admin";
    }

}
