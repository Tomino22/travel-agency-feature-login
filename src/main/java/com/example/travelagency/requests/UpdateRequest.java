package com.example.travelagency.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UpdateRequest {

    @NotNull
    @Positive(message="Incorrect id")
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private String roomType;

    @NotEmpty
    private String destination;

    @NotEmpty
    private long countryId;

}
