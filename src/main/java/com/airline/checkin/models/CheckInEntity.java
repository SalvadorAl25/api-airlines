package com.airline.checkin.models;

import java.util.List;

public class CheckInEntity {

    private Integer flightId;

    private Integer takeoffDateTime;

    private String takeoffAirport;

    private Integer landingDateTime;

    private String landingAirport;

    private Integer airlineId;

    private List<ManyPassengersEntity> passengers;

    public CheckInEntity() {
    }

    public CheckInEntity(Integer flightId, Integer takeoffDateTime, String takeoffAirport, Integer landingDateTime, String landingAirport, Integer airlineId, List<ManyPassengersEntity> passengers) {
        this.flightId = flightId;
        this.takeoffDateTime = takeoffDateTime;
        this.takeoffAirport = takeoffAirport;
        this.landingDateTime = landingDateTime;
        this.landingAirport = landingAirport;
        this.airlineId = airlineId;
        this.passengers = passengers;
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

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public List<ManyPassengersEntity> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<ManyPassengersEntity> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "CheckInEntity{" +
                "flightId=" + flightId +
                ", takeoffDateTime=" + takeoffDateTime +
                ", takeoffAirport='" + takeoffAirport + '\'' +
                ", landingDateTime=" + landingDateTime +
                ", landingAirport='" + landingAirport + '\'' +
                ", airlineId=" + airlineId +
                ", passengers=" + passengers +
                '}';
    }
}
