package com.example.travelagency.services;

import com.example.travelagency.entities.TermEntity;
import com.example.travelagency.entities.VacationEntity;
import com.example.travelagency.repositories.TermRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermService {

    private final TermRepository termRepository;


    public TermService(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public List<TermEntity> getAllTerms(Long vacationId) {
        return termRepository.findAllByVacationEntity_Id(vacationId);

    }
}
