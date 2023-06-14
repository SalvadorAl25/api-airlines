package com.airline.checkin.repositories;

import com.airline.checkin.models.SeatTypeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SeatTypeRepository extends CrudRepository<SeatTypeEntity, Integer>{
}
