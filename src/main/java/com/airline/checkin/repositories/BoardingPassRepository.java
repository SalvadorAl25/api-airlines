package com.airline.checkin.repositories;
import com.airline.checkin.models.BoardingPassEntity;
import com.airline.checkin.models.SeatEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface BoardingPassRepository extends CrudRepository<BoardingPassEntity, Integer> {

    @Query("select bp from BoardingPassEntity bp join bp.flight f where f.flightId=:flightId")
    List<BoardingPassEntity> findByFlightId(@Param("flightId") Integer flightId);

    @Query("select bp.seat from BoardingPassEntity bp join bp.seat s join bp.flight f where s.seatId=:seatId and f.flightId=:flightId")
    SeatEntity findIfTheSeatIsFree(@Param("seatId") Integer seatId, @Param("flightId") Integer flightId);

}
