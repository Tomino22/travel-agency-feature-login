package com.example.travelagency.entities;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="country_id")
    private long id;

    @Column(name="country_name")
    private String name;
}
