package com.airline.checkin.repositories;

import com.airline.checkin.models.AirplaneEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AirplaneRepository extends CrudRepository<AirplaneEntity, Integer>{
}
