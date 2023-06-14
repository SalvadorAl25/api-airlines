package com.airline.checkin.models;

import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class PassengerEntity {

    @Id
    @Comment("Identificador de la tabla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer passengerId;

    @Column(nullable = false)
    @Comment("Número de identificación del pasajero")
    private String dni;

    @Column(nullable = false)
    @Comment("Nombre completo del pasajero")
    private String name;

    @Column(nullable = false)
    @Comment("Edad del pasajero")
    private Integer age;

    @Column(nullable = false)
    @Comment("País del pasajero")
    private String country;

    public PassengerEntity() {
    }

    public PassengerEntity(Integer passengerId, String dni, String name, Integer age, String country) {
        this.passengerId = passengerId;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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

    @Override
    public String toString() {
        return "PassengerEntity{" +
                "passengerId=" + passengerId +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
