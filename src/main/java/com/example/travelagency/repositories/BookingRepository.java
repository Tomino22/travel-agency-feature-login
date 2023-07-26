package com.example.travelagency.repositories;

import com.example.travelagency.entities.BookingEntity;
import com.example.travelagency.entities.TermEntity;
import com.example.travelagency.entities.UserEntity;
import com.example.travelagency.entities.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository< BookingEntity, Long> {
    List<BookingEntity> findBookingEntitiesByUserEntity_Id(Long id);

}