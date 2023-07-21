package com.example.travelagency.services;


import com.example.travelagency.entities.BookingEntity;
import com.example.travelagency.repositories.BookingRepository;
import com.example.travelagency.repositories.TermRepository;
import com.example.travelagency.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    private final TermRepository termRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, TermRepository termRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.termRepository = termRepository;
    }

    public BookingEntity book(long termId, long userId) {
        var userEntity = userRepository.getReferenceById(userId);
        var termEntity = termRepository.getReferenceById(termId);
//        var bookingEntity = BookingEntity.builder()
//                .termEntity(termEntity)
//                .userEntity(userEntity)
//                .build();

        var bookingEntity = new BookingEntity();
        bookingEntity.setUserEntity(userEntity);
        bookingEntity.setTermEntity(termEntity);

        return bookingRepository.save(bookingEntity);
    }
}
