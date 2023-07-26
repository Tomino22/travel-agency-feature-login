package com.example.travelagency.services;

import com.example.travelagency.entities.CountryEntity;
import com.example.travelagency.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public Optional<CountryEntity> getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public Set<CountryEntity> getAllCountryNames() throws Exception {
        return countryRepository.findByOrderByNameAsc();
    }

    public List<CountryEntity> getAll(){
        return countryRepository.findAll();
    }

   }
