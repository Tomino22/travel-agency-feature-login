package com.example.travelagency.repositories;

import com.example.travelagency.entities.CountryEntity;
import com.example.travelagency.entities.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<VacationEntity, Long> {

    List<VacationEntity> findAllByOrderByNameAsc();

    List<VacationEntity> findAllByCountryEntity(CountryEntity countryEntity);

    List<VacationEntity> findByNameContainingIgnoreCase(String searchText);
    List<VacationEntity> findByCountryEntityName(String countryName);


}
