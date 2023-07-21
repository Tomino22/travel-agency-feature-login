package com.example.travelagency.services;

import com.example.travelagency.entities.VacationEntity;
import com.example.travelagency.repositories.CountryRepository;
import com.example.travelagency.repositories.VacationRepository;
import com.example.travelagency.requests.SearchRequest;
import com.example.travelagency.requests.UpdateRequest;
import com.example.travelagency.requests.VacationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class VacationService {

    private VacationRepository vacationRepository;
    private CountryRepository countryRepository;

    public VacationService(VacationRepository vacationRepository, CountryRepository countryRepository) {
        this.vacationRepository = vacationRepository;
        this.countryRepository = countryRepository;
    }

    public List<VacationEntity> getAll(){
        return vacationRepository.findAll();
    }

    public List<VacationEntity> getAllByNameAsc(){
        return vacationRepository.findAllByOrderByNameAsc();

    }

    public List<VacationEntity> getVacationsByCountry (String name){
        return countryRepository
                .findByName(name)
                .map(country -> vacationRepository.findAllByCountryEntity(country))
                .orElse(List.of());

    }

    public void insertVacation (VacationRequest vacationRequest) throws Exception {
        var newVacation = new VacationEntity();
        newVacation.setName(vacationRequest.getName());
        newVacation.setDescription(vacationRequest.getDescription());
        newVacation.setDestination(vacationRequest.getDestination());
        newVacation.setRoomType(vacationRequest.getRoomType());
        var country = countryRepository.findById(vacationRequest.getCountryId()).orElse(null);
        newVacation.setCountryEntity(country);
        vacationRepository.save(newVacation);
    }

    public List<VacationEntity> searchInput (String searchText) {
        return vacationRepository.findByNameContainingIgnoreCase(searchText);


    }

    public void updateVacation (Long vacationId, UpdateRequest updateRequest) {

       var updatedVacation = vacationRepository
               .findById(vacationId)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       var country = countryRepository.findById(updateRequest.getCountryId()).orElse(null);
       updatedVacation.setName(updateRequest.getName());
       updatedVacation.setDestination(updateRequest.getDestination());
       updatedVacation.setDescription(updateRequest.getDescription());
       updatedVacation.setRoomType(updateRequest.getRoomType());
       updatedVacation.setCountryEntity(country);
       vacationRepository.save(updatedVacation);
    }

    public VacationEntity getVacationById(long vacationId) {
        return vacationRepository
                .findById(vacationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteVacationById(long vacationId) {
        var vacation = getVacationById(vacationId);
        vacationRepository.delete(vacation);
    }
    public long getNumberOfVacations(){
        return vacationRepository.count();
    }
}
