package com.airline.checkin.controllers;

import com.airline.checkin.models.CheckInEntity;
import com.airline.checkin.models.EndPointEntity;
import com.airline.checkin.services.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights/")
public class CheckInController {

    @Autowired
    BoardingPassService boardingPassService;

    @CrossOrigin
    @GetMapping("{flightId}/passengers")
    public EndPointEntity checkIn(@PathVariable("flightId") Integer flightId){
        HttpStatus statusCode = HttpStatus.OK;
        EndPointEntity endPointEntity = new EndPointEntity();


        if (statusCode.value() == 200) {
            endPointEntity.setCode(statusCode.value());
            endPointEntity.setData(boardingPassService.checkIn(flightId));
            return endPointEntity;
        } else if (statusCode.value() == 404) {
            endPointEntity.setCode(statusCode.value());
            return endPointEntity;
        } else if (statusCode.value() == 400){
            endPointEntity.setCode(statusCode.value());
            endPointEntity.setErrors("could not connect to db");
            return endPointEntity;
        }
        return null;
    }
}
