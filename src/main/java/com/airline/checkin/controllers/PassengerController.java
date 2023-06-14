package com.airline.checkin.controllers;

import com.airline.checkin.models.PassengerEntity;
import com.airline.checkin.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @CrossOrigin
    @GetMapping(path = "passengers")
    public Iterable<PassengerEntity> findAll() {
        return passengerService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "passenger/{passengerId}")
    public Optional<PassengerEntity> findById(@PathVariable("passengerId") Integer passengerId) {
        return passengerService.findById(passengerId);
    }

    @CrossOrigin
    @PostMapping(path = "passenger")
    public void save(@RequestBody PassengerEntity passenger) {
        passengerService.save(passenger);
    }

    @CrossOrigin
    @DeleteMapping(path = "passenger")
    public void delete(@RequestBody PassengerEntity passenger) {
        passengerService.delete(passenger);
    }
}
