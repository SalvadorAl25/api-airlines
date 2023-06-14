package com.airline.checkin.services;
import com.airline.checkin.models.AirplaneEntity;
import com.airline.checkin.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    public ArrayList<AirplaneEntity> findAll(){
        return (ArrayList<AirplaneEntity>) airplaneRepository.findAll();
    }

    public Optional<AirplaneEntity> findById(Integer airplaneId){
        return airplaneRepository.findById(airplaneId);
    }

    public void save(AirplaneEntity airplane){
        airplaneRepository.save(airplane);
    }

    public void delete(AirplaneEntity airplane){
        airplaneRepository.delete(airplane);
    }
}
