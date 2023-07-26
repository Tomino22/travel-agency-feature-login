package com.example.travelagency.repositories;

import com.example.travelagency.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

   Optional<CountryEntity> findByName (String name);

   List<CountryEntity> findAllByName(String name);

   Set<CountryEntity> findByOrderByNameAsc();
   List<CountryEntity> findAll();



}
