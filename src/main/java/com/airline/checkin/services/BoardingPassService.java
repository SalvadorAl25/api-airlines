package com.airline.checkin.services;

import com.airline.checkin.models.BoardingPassEntity;
import com.airline.checkin.models.CheckInEntity;
import com.airline.checkin.models.ManyPassengersEntity;
import com.airline.checkin.models.PassengerEntity;
import com.airline.checkin.repositories.BoardingPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BoardingPassService {

    @Autowired
    BoardingPassRepository boardingPassRepository;

    CheckInEntity checkIn = new CheckInEntity();

    public Iterable<BoardingPassEntity> findAll() {
        return boardingPassRepository.findAll();
    }

    public Optional<BoardingPassEntity> findById(Integer boardingPassId) {
        return boardingPassRepository.findById(boardingPassId);
    }

    public List<BoardingPassEntity> findByFlightId(Integer flightId) {
        return boardingPassRepository.findByFlightId(flightId);
    }
    
    private List<ManyPassengersEntity> findAllPassengers(List<BoardingPassEntity> boardings){
        List<ManyPassengersEntity> manyPassengers = new ArrayList<>();
        for(int i=0; i<boardings.size(); i++){
            ManyPassengersEntity passengerCheckIn = new ManyPassengersEntity();
            passengerCheckIn.setPassengerId(boardings.get(i).getPassenger().getPassengerId());
            passengerCheckIn.setDni(Integer.parseInt(boardings.get(i).getPassenger().getDni()));
            passengerCheckIn.setName(boardings.get(i).getPassenger().getName());
            passengerCheckIn.setAge(boardings.get(i).getPassenger().getAge());
            passengerCheckIn.setCountry(boardings.get(i).getPassenger().getCountry());
            passengerCheckIn.setBoardingPassId(boardings.get(i).getBoardingPassId());
            passengerCheckIn.setPurchaseId(boardings.get(i).getPurchase().getPurchaseId());
            passengerCheckIn.setSeatTypeId(boardings.get(i).getSeatType().getSeatTypeId());
            if (boardings.get(i).getSeat() != null)
                passengerCheckIn.setSeatId(boardings.get(i).getSeat().getSeatId());
            manyPassengers.add(passengerCheckIn);
        }
        manyPassengers.sort(Comparator.comparing(ManyPassengersEntity::getPurchaseId));
        return manyPassengers;
    }

    private CheckInEntity findTheFlight(Integer flightId){
        List<BoardingPassEntity> boardings = boardingPassRepository.findByFlightId(flightId);
        checkIn.setFlightId(boardings.get(0).getFlight().getFlightId());
        checkIn.setTakeoffDateTime(boardings.get(0).getFlight().getTakeoffDateTime());
        checkIn.setTakeoffAirport(boardings.get(0).getFlight().getTakeoffAirport());
        checkIn.setLandingDateTime(boardings.get(0).getFlight().getLandingDateTime());
        checkIn.setLandingAirport(boardings.get(0).getFlight().getLandingAirport());
        checkIn.setAirlineId(boardings.get(0).getFlight().getAirline().getAirplaneId());
        checkIn.setPassengers(findAllPassengers(boardings));
        return checkIn;
        //checkInFindPassengers(boardingPass);
    }

    public CheckInEntity checkIn(Integer flightId){
        return findTheFlight(flightId);
    }

    public void save(BoardingPassEntity boardingPass) {
        boardingPassRepository.save(boardingPass);
    }

    public void delete(BoardingPassEntity boardingPass) {
        boardingPassRepository.delete(boardingPass);
    }
}
