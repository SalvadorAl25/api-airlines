package com.airline.checkin.models;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;


@Entity
@Table(name = "boarding_pass")
public class BoardingPassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    @Comment("Identificador de la tabla")
    private Integer boardingPassId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "purchase_id", foreignKey = @ForeignKey(name = "purchase_id_bp"),nullable = false)
    @Comment("Id de la compra")
    private PurchaseEntity purchase;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "passenger_id", foreignKey = @ForeignKey(name = "passenger_id_bp"), nullable = false)
    @Comment("Id del pasajero")
    private PassengerEntity passenger;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "seat_type_id", foreignKey = @ForeignKey(name = "seat_type_id_bp"),nullable = false)
    @Comment("Id del tipo de asiento")
    private SeatTypeEntity seatType;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "seat_id",foreignKey = @ForeignKey(name = "seat_id_bp"))
    @Comment("Id del asiento")
    private SeatEntity seat;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "flight_id", foreignKey = @ForeignKey(name = "flight_id_bp"), nullable = false)
    @Comment("Id del Vuelo")
    private FlightEntity flight;

    public BoardingPassEntity() {
    }

    public BoardingPassEntity(Integer boardingPassId, PurchaseEntity purchase, PassengerEntity passenger, SeatTypeEntity seatType, SeatEntity seat, FlightEntity flight) {
        this.boardingPassId = boardingPassId;
        this.purchase = purchase;
        this.passenger = passenger;
        this.seatType = seatType;
        this.seat = seat;
        this.flight = flight;
    }

    public Integer getBoardingPassId() {
        return boardingPassId;
    }

    public void setBoardingPassId(Integer boardingPassId) {
        this.boardingPassId = boardingPassId;
    }

    public PurchaseEntity getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseEntity purchase) {
        this.purchase = purchase;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }

    public SeatTypeEntity getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatTypeEntity seatType) {
        this.seatType = seatType;
    }

    public SeatEntity getSeat() {
        return seat;
    }

    public void setSeat(SeatEntity seat) {
        this.seat = seat;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "BoardingPassEntity{" +
                "boardingPassId=" + boardingPassId +
                ", purchase=" + purchase +
                ", passenger=" + passenger +
                ", seatType=" + seatType +
                ", seat=" + seat +
                ", flight=" + flight +
                '}';
    }
}
