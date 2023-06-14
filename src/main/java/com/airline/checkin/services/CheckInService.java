package com.airline.checkin.services;

import com.airline.checkin.models.BoardingPassEntity;
import com.airline.checkin.models.CheckInEntity;
import com.airline.checkin.models.ManyPassengersEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class CheckInService {

    @Autowired
    BoardingPassService boardingPassService;

    Optional<BoardingPassEntity> boardingPasses;

    CheckInEntity checkIn;

    List<ManyPassengersEntity> passengers;

    public void checkInFindFlight(Integer flightId){
        boardingPasses = boardingPassService.findById(flightId);
        List<BoardingPassEntity> boardingPass = boardingPasses.map(valor -> Stream.of(valor).collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
        checkIn.setFlightId(boardingPass.get(0).getFlight().getFlightId());
        checkIn.setTakeoffDateTime(boardingPass.get(0).getFlight().getTakeoffDateTime());
        checkIn.setTakeoffAirport(boardingPass.get(0).getFlight().getTakeoffAirport());
        checkIn.setLandingDateTime(boardingPass.get(0).getFlight().getLandingDateTime());
        checkIn.setLandingAirport(boardingPass.get(0).getFlight().getLandingAirport());
        checkIn.setAirlineId(boardingPass.get(0).getFlight().getAirline().getAirplaneId());
        checkInFindPassengers(boardingPass);
    }

    public void checkInFindPassengers(List<BoardingPassEntity> boardingPass){
        ManyPassengersEntity passenger;

        for (int i = 0; i<boardingPass.size(); i++){

        }
    }
}
