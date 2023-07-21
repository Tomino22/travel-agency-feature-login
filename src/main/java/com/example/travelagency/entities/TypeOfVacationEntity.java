package com.example.travelagency.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="type_of_vacation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder


public class TypeOfVacationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="type_of_vacation_id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;


}
