package com.airline.checkin.repositories;

import com.airline.checkin.models.SeatEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SeatRepository extends CrudRepository<SeatEntity, Integer>{
}
