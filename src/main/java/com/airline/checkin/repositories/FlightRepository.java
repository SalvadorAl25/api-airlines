package com.airline.checkin.repositories;

import com.airline.checkin.models.FlightEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface FlightRepository extends CrudRepository<FlightEntity,Integer>{

}
