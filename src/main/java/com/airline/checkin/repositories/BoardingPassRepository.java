package com.airline.checkin.repositories;
import com.airline.checkin.models.BoardingPassEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface BoardingPassRepository extends CrudRepository<BoardingPassEntity, Integer> {

    @Query("select bp from BoardingPassEntity bp join bp.flight f where f.flightId=:flightId")
    List<BoardingPassEntity> findByFlightId(@Param("flightId") Integer flightId);
}
