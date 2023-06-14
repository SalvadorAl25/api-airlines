package com.airline.checkin.repositories;

import com.airline.checkin.models.PassengerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PassengerRepository extends CrudRepository<PassengerEntity,Integer>{
}
