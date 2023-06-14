package com.airline.checkin.controllers;

import com.airline.checkin.models.AirplaneEntity;
import com.airline.checkin.services.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;

    @CrossOrigin
    @GetMapping(path = "airplanes")
    public ArrayList<AirplaneEntity> findAll() {
        return airplaneService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "airplane/{airplaneId}")
    public Optional<AirplaneEntity> findById(@PathVariable("airplaneId") Integer airplaneId) {
        return airplaneService.findById(airplaneId);
    }

    @CrossOrigin
    @PostMapping(path = "airplane")
    public void save(@RequestBody AirplaneEntity airplane) {
        airplaneService.save(airplane);
    }

    @CrossOrigin
    @DeleteMapping(path = "airplane")
    public void delete(@RequestBody AirplaneEntity airplane) {
        airplaneService.delete(airplane);
    }
}
