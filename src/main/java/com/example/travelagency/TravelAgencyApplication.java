package com.example.travelagency;

import com.example.travelagency.repositories.CountryRepository;
import com.example.travelagency.repositories.VacationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelAgencyApplication {

    private final VacationRepository vacationRepository;
    private final CountryRepository countryRepository;

    public TravelAgencyApplication(VacationRepository vacationRepository, CountryRepository countryRepository) {
        this.vacationRepository = vacationRepository;
        this.countryRepository = countryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyApplication.class, args);
    }

}

