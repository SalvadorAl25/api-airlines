package com.airline.checkin.controllers;

import com.airline.checkin.models.BoardingPassEntity;
import com.airline.checkin.services.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class BoardingPassController {

    @Autowired
    BoardingPassService boardingPassService;

    @CrossOrigin
    @GetMapping(path = "boardingPassengers")
    public Iterable<BoardingPassEntity> findAll() {
        return boardingPassService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "boardingPass/{boardingPassId}")
    public Optional<BoardingPassEntity> findById(@PathVariable("boardingPassId") Integer boardingPassId) {
        return boardingPassService.findById(boardingPassId);
    }

    @CrossOrigin
    @PostMapping(path = "boarding")
    public void save(@RequestBody BoardingPassEntity boardingPass) {
        boardingPassService.save(boardingPass);
    }

    @CrossOrigin
    @DeleteMapping(path = "boarding")
    public void delete(@RequestBody BoardingPassEntity boardingPass) {
        boardingPassService.delete(boardingPass);
    }
}
