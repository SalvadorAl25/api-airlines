package com.airline.checkin.services;

import com.airline.checkin.models.PassengerEntity;
import com.airline.checkin.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public Iterable<PassengerEntity> findAll() {
        return passengerRepository.findAll();
    }

    public Optional<PassengerEntity> findById(Integer passengerId) {
        return passengerRepository.findById(passengerId);
    }

    public void save(PassengerEntity passenger) {
        passengerRepository.save(passenger);
    }

    public void delete(PassengerEntity passenger) {
        passengerRepository.delete(passenger);
    }
}
