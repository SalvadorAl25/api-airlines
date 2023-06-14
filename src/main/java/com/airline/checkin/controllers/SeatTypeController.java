package com.airline.checkin.controllers;

import com.airline.checkin.models.SeatTypeEntity;
import com.airline.checkin.services.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class SeatTypeController {

    @Autowired
    SeatTypeService seatTypeService;

    @CrossOrigin
    @GetMapping(path = "seatTypes")
    public Iterable<SeatTypeEntity> findAll() {
        return seatTypeService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "seatType/{seatTypeId}")
    public Optional<SeatTypeEntity> findById(@PathVariable("seatTypeId") Integer seatTypeId) {
        return seatTypeService.findById(seatTypeId);
    }

    @CrossOrigin
    @PostMapping(path = "seatType")
    public void save(@RequestBody SeatTypeEntity seatType) {
        seatTypeService.save(seatType);
    }

    @CrossOrigin
    @DeleteMapping(path = "seatType")
    public void delete(@PathVariable SeatTypeEntity seatType) {
        seatTypeService.delete(seatType);
    }
}
