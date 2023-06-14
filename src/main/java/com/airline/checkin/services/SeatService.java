package com.airline.checkin.services;

import com.airline.checkin.models.SeatEntity;
import com.airline.checkin.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    public Iterable<SeatEntity> findAll() {
        return seatRepository.findAll();
    }

    public Optional<SeatEntity> findById(Integer seatId) {
        return seatRepository.findById(seatId);
    }

    public void save(SeatEntity seat) {
        seatRepository.save(seat);
    }

    public void delete(SeatEntity seat) {
        seatRepository.delete(seat);
    }
}
