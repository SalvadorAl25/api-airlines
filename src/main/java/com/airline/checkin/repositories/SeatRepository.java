package com.airline.checkin.repositories;

import com.airline.checkin.models.SeatEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<SeatEntity, Integer>{

    @Query("select s.seatId from SeatEntity s join s.airplane a where s.seatColumn=:seatColumn and s.seatRow=:seatRow and a.airplaneId=:airplaneId")
    Integer findSeatByColumnAndRow(@Param("seatColumn") String seatColumn,
                                          @Param("seatRow") Integer seatRow,
                                          @Param("airplaneId") Integer airplaneId);

    @Query("SELECT s.seatId FROM SeatEntity s " +
            "JOIN s.seatType st " +
            "JOIN s.airplane ai " +
            "WHERE st.seatTypeId=:seatTypeId " +
            "AND ai.airplaneId=:airplaneId " +
            "ORDER BY s.seatRow ASC, s.seatColumn ASC")
    List<Integer> allSeatsForType(@Param("seatTypeId") Integer seatTypeId, @Param("airplaneId") Integer airplaneId);
}
