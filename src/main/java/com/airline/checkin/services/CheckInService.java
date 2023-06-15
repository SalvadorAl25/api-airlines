package com.airline.checkin.services;

import com.airline.checkin.models.BoardingPassEntity;
import com.airline.checkin.models.CheckInEntity;
import com.airline.checkin.models.ManyPassengersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class CheckInService {

    @Autowired
    BoardingPassService boardingPassService;
    CheckInEntity checkIn;
    List<ManyPassengersEntity> passengers;

    public static String checkInFindFlight(Integer flightId){
        return "Entro al servicio con el Id = "+flightId;
        /*checkIn.setFlightId(boardingPasses.get(0).getFlight().getFlightId());
        checkIn.setTakeoffDateTime(boardingPasses.get(0).getFlight().getTakeoffDateTime());
        checkIn.setTakeoffAirport(boardingPasses.get(0).getFlight().getTakeoffAirport());
        checkIn.setLandingDateTime(boardingPasses.get(0).getFlight().getLandingDateTime());
        checkIn.setLandingAirport(boardingPasses.get(0).getFlight().getLandingAirport());
        checkIn.setAirlineId(boardingPasses.get(0).getFlight().getAirline().getAirplaneId());
        System.out.println(checkIn);*/
        //checkInFindPassengers(boardingPass);
    }

    public void checkInFindPassengers(List<BoardingPassEntity> boardingPass){
        ManyPassengersEntity passenger;

        for (int i = 0; i<boardingPass.size(); i++){
        }
    }
}
