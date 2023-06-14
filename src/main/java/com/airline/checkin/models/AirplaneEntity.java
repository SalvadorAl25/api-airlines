package com.airline.checkin.models;


import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name = "airplane")
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    @Comment("Identificador de la tabla")
    private Integer airplaneId;

    @Column(nullable = false)
    @Comment("Nombre del Avión")
    private String name;

    public AirplaneEntity() {
    }

    public AirplaneEntity(Integer airplaneId, String name) {
        this.airplaneId = airplaneId;
        this.name = name;
    }

    public Integer getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AirplaneEntity{" +
                "airplaneId=" + airplaneId +
                ", name='" + name + '\'' +
                '}';
    }
}
