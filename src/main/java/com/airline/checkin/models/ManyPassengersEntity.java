package com.airline.checkin.models;

public class ManyPassengersEntity {

    private Integer passengerId;

    private Integer dni;

    private String name;

    private Integer age;

    private String country;

    private Integer boardingPassId;

    private Integer purchaseId;

    private Integer seatTypeId;

    private Integer seatId;

    public ManyPassengersEntity() {
    }

    public ManyPassengersEntity(Integer passengerId, Integer dni, String name, Integer age, String country, Integer boardingPassId, Integer purchaseId, Integer seatTypeId, Integer seatId) {
        this.passengerId = passengerId;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.country = country;
        this.boardingPassId = boardingPassId;
        this.purchaseId = purchaseId;
        this.seatTypeId = seatTypeId;
        this.seatId = seatId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getBoardingPassId() {
        return boardingPassId;
    }

    public void setBoardingPassId(Integer boardingPassId) {
        this.boardingPassId = boardingPassId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "ManyPassengersEntity{" +
                "passengerId=" + passengerId +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", boardingPassId=" + boardingPassId +
                ", purchaseId=" + purchaseId +
                ", seatTypeId=" + seatTypeId +
                ", seatId=" + seatId +
                '}';
    }
}
