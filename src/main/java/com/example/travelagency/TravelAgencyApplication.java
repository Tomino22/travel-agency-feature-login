package com.example.travelagency;

import com.example.travelagency.entities.CountryEntity;
import com.example.travelagency.entities.VacationEntity;
import com.example.travelagency.repositories.CountryRepository;
import com.example.travelagency.repositories.VacationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            try {
//                var chorvatsko = CountryEntity.builder().name("Chorvátsko").build();
//                this.countryRepository.save(chorvatsko);
//                this.vacationRepository.saveAll(List.of(
//                        new VacationEntity(1, "Istria", "prímorské", "hotel", "More", chorvatsko),
//                        new VacationEntity(2, "Hvar", "prímorské", "apartmán", "More", chorvatsko),
//                        new VacationEntity(3, "Krk", "prímorské", "double-room", "More", chorvatsko)
//                ));
//
//
//            } catch (Exception e) {
//                // ...
//
//            }
//        };
//
//
//    }
}

