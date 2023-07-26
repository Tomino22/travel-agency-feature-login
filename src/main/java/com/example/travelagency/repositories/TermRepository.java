package com.example.travelagency.repositories;

import com.example.travelagency.entities.TermEntity;
import com.example.travelagency.entities.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermRepository extends JpaRepository<TermEntity, Long> {


    List<TermEntity> findAllByVacationEntity_Id(Long id);
    List<TermEntity> findAllById(Long id);
}
