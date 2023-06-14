package com.airline.checkin.models;

import org.hibernate.annotations.Columns;
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
@Table(name = "flight")
public class FlightEntity {

    @Id
    @Comment("Identificador de la tabla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer flightId;

    @Column(nullable = false)
    @Comment("Fecha y hora del despegue")
    private Integer takeoffDateTime;

    @Column(nullable = false)
    @Comment("Aeropuerto de despegue")
    private String takeoffAirport;

    @Column(nullable = false)
    @Comment("Fecha y hora del aterrizaje")
    private Integer landingDateTime;

    @Column(nullable = false)
    @Comment("Aeropuerto de aterrizaje")
    private String landingAirport;

    @Comment("Id del avión")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "airplane_id", foreignKey = @ForeignKey(name = "airplane_id_fl"), nullable = false)
    private AirplaneEntity airline;

    public FlightEntity() {
    }

    public FlightEntity(Integer flightId, Integer takeoffDateTime, String takeoffAirport, Integer landingDateTime, String landingAirport, AirplaneEntity airline) {
        this.flightId = flightId;
        this.takeoffDateTime = takeoffDateTime;
        this.takeoffAirport = takeoffAirport;
        this.landingDateTime = landingDateTime;
        this.landingAirport = landingAirport;
        this.airline = airline;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getTakeoffDateTime() {
        return takeoffDateTime;
    }

    public void setTakeoffDateTime(Integer takeoffDateTime) {
        this.takeoffDateTime = takeoffDateTime;
    }

    public String getTakeoffAirport() {
        return takeoffAirport;
    }

    public void setTakeoffAirport(String takeoffAirport) {
        this.takeoffAirport = takeoffAirport;
    }

    public Integer getLandingDateTime() {
        return landingDateTime;
    }

    public void setLandingDateTime(Integer landingDateTime) {
        this.landingDateTime = landingDateTime;
    }

    public String getLandingAirport() {
        return landingAirport;
    }

    public void setLandingAirport(String landingAirport) {
        this.landingAirport = landingAirport;
    }

    public AirplaneEntity getAirline() {
        return airline;
    }

    public void setAirline(AirplaneEntity airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "flightId=" + flightId +
                ", takeoffDateTime=" + takeoffDateTime +
                ", takeoffAirport='" + takeoffAirport + '\'' +
                ", landingDateTime=" + landingDateTime +
                ", landingAirport='" + landingAirport + '\'' +
                ", airline=" + airline +
                '}';
    }
}
