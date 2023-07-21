package com.example.travelagency.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SearchRequest {


    private String name;

    private LocalDate date;
}
