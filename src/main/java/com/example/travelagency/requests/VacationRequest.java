package com.example.travelagency.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class VacationRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;
    @NotEmpty
    private String roomType;
    @NotEmpty
    private String destination;

    private Long countryId;

    private Long termID;



}
