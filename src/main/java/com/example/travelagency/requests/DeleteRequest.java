package com.example.travelagency.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteRequest {


     @NotEmpty
    private long id;
}
