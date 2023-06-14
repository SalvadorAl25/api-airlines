package com.airline.checkin.services;

import com.airline.checkin.models.SeatEntity;
import com.airline.checkin.models.SeatTypeEntity;
import com.airline.checkin.repositories.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatTypeService {

    @Autowired
    SeatTypeRepository seatTypeRepository;

    public Iterable<SeatTypeEntity> findAll() {
        return seatTypeRepository.findAll();
    }

    public Optional<SeatTypeEntity> findById(Integer seatTypeId) {
        return seatTypeRepository.findById(seatTypeId);
    }

    public void  save(SeatTypeEntity seatType) {
        seatTypeRepository.save(seatType);
    }

    public void delete(SeatTypeEntity seatType) {
        seatTypeRepository.delete(seatType);
    }
}
