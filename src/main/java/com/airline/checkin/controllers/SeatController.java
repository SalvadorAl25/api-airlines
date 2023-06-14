package com.airline.checkin.controllers;

import com.airline.checkin.models.SeatEntity;
import com.airline.checkin.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class SeatController {

    @Autowired
    SeatService seatService;

    @CrossOrigin
    @GetMapping(path = "seats")
    public Iterable<SeatEntity> findAll() {
        return seatService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "seat/{seatId}")
    public Optional<SeatEntity> findById(@PathVariable("seatId") Integer seatId) {
        return seatService.findById(seatId);
    }

    @CrossOrigin
    @PostMapping(path = "seat")
    public void save(@RequestBody SeatEntity seat) {
        seatService.save(seat);
    }

    @CrossOrigin
    @DeleteMapping(path = "seat")
    public void delete(@RequestBody SeatEntity seat) {
        seatService.delete(seat);
    }
}
