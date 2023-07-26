package com.example.travelagency.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "vacation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class VacationEntity {

    @Id
    @Column(name = "vacation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "room_type", nullable = false)
    private String roomType;

    @Column(name = "destination", nullable = false)
    private String destination;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name="country_id", nullable = true)
    private CountryEntity countryEntity;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name="type_of_vacation_id", nullable = true)
    private TypeOfVacationEntity typeOfVacationEntity;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name="term_id", nullable = true)
//    private TermEntity termEntity;

    public VacationEntity(long id, String name, String description, String roomType, String destination) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roomType = roomType;
        this.destination = destination;
    }

    public VacationEntity(long id, String name, String description, String roomType, String destination, CountryEntity countryEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roomType = roomType;
        this.destination = destination;
        this.countryEntity = countryEntity;
    }
}


