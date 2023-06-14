package com.airline.checkin.services;

import com.airline.checkin.models.FlightEntity;
import com.airline.checkin.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public Iterable<FlightEntity> findAll() {
        return flightRepository.findAll();
    }

    public Optional<FlightEntity> findById(Integer flightId) {
        return flightRepository.findById(flightId);
    }

    public void save(FlightEntity flightEntity) {
        flightRepository.save(flightEntity);
    }

    public void delete(FlightEntity entity) {
        flightRepository.delete(entity);
    }
}
