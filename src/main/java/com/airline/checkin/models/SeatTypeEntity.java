package com.airline.checkin.models;

import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "seat_type")
public class SeatTypeEntity {

    @Id
    @Comment("Identificador de la tabla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer seatTypeId;

    @Column(nullable = false)
    @Comment("Nombre del tipo de asiento")
    private String name;

    public SeatTypeEntity() {
    }

    public SeatTypeEntity(Integer seatTypeId, String name) {
        this.seatTypeId = seatTypeId;
        this.name = name;
    }

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SeatTypeEntity{" +
                "seatTypeId=" + seatTypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
