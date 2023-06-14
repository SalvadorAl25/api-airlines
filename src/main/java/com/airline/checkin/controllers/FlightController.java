package com.airline.checkin.controllers;

import com.airline.checkin.models.FlightEntity;
import com.airline.checkin.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class FlightController {

    @Autowired
    FlightService flightService;

    @CrossOrigin
    @GetMapping(path = "flights")
    public Iterable<FlightEntity> findAll() {
        return flightService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "flight/{flightId}")
    public Optional<FlightEntity> findById(@PathVariable("flightId") Integer flightId) {
        Optional<FlightEntity> flight = flightService.findById(flightId);
        System.out.println(flight);
        return flightService.findById(flightId);
    }

    @CrossOrigin
    @PostMapping(path = "flight")
    public void save(@RequestBody FlightEntity flightEntity) {
        flightService.save(flightEntity);
    }

    @CrossOrigin
    @DeleteMapping(path = "flight")
    public void delete(@RequestBody FlightEntity entity) {
        flightService.delete(entity);
    }
}
