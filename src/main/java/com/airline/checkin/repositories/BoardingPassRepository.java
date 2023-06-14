package com.airline.checkin.repositories;
import com.airline.checkin.models.BoardingPassEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BoardingPassRepository extends CrudRepository<BoardingPassEntity, Integer> {


}
