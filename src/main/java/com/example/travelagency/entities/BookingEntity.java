package com.example.travelagency.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity(name="booking")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class BookingEntity {

    @Id
    @Column(name="booking_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="create_date")
    @CreationTimestamp
    private LocalDate createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="term_id")
    private TermEntity termEntity;




}
