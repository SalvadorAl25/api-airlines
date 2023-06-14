package com.airline.checkin.models;

import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {

    @Id
    @Comment("Identificador de la tabla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer purchaseId;

    @Column(nullable = false)
    @Comment("Fecha de la compra")
    private Integer purchaseDate;

    public PurchaseEntity() {
    }

    public PurchaseEntity(Integer purchaseId, Integer purchaseDate) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Integer purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "purchaseId=" + purchaseId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
