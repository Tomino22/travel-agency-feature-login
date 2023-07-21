package com.example.travelagency.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity(name="term")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class TermEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="term_id")
    private long id;

    @Column(name="check_in")
    private LocalDate checkIn;

    @Column(name="check_out")
    private LocalDate checkOut;

    @Column(name="price")
    private long price;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name="vacation_id")
    private VacationEntity vacationEntity;







}
