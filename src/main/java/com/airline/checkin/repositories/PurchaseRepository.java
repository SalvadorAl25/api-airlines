package com.airline.checkin.repositories;

import com.airline.checkin.models.PurchaseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Integer>{
}
