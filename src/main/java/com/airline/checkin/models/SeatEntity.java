package com.airline.checkin.models;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class SeatEntity {

    @Id
    @Comment("Identificador de la tabla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer seatId;

    @Column(nullable = false, length = 2)
    @Comment("Columna del asiento")
    private String seatColumn;

    @Column(nullable = false)
    @Comment("Fila del asiento")
    private Integer seatRow;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "seat_type_id", foreignKey = @ForeignKey(name = "seat_type_id_se"), nullable = false)
    @Comment("Id del tipo de asiento {FK}")
    private SeatTypeEntity seatType;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "airplane_id", foreignKey = @ForeignKey(name = "airplane_id_se"), nullable = false)
    @Comment("Id del avión al que pertenece el asiento")
    private AirplaneEntity airplane;

    public SeatEntity() {
    }

    public SeatEntity(Integer seatId, String seatColumn, Integer seatRow, SeatTypeEntity seatType, AirplaneEntity airplane) {
        this.seatId = seatId;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.seatType = seatType;
        this.airplane = airplane;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public SeatTypeEntity getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatTypeEntity seatType) {
        this.seatType = seatType;
    }

    public AirplaneEntity getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneEntity airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "SeatEntity{" +
                "seatId=" + seatId +
                ", seatColumn='" + seatColumn + '\'' +
                ", seatRow=" + seatRow +
                ", seatType=" + seatType +
                ", airplane=" + airplane +
                '}';
    }
}
