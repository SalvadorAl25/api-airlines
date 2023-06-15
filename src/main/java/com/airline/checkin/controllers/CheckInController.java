package com.airline.checkin.controllers;

import com.airline.checkin.models.CheckInEntity;
import com.airline.checkin.services.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights/")
public class CheckInController {

    @Autowired
    BoardingPassService boardingPassService;

    @CrossOrigin
    @GetMapping("{flightId}/passengers")
    public CheckInEntity checkIn(@PathVariable("flightId") Integer flightId){
        return boardingPassService.checkIn(flightId);
    }
}
