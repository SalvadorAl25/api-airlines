package com.airline.checkin.services;

import com.airline.checkin.models.PurchaseEntity;
import com.airline.checkin.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public Iterable<PurchaseEntity> findAll() {
        return purchaseRepository.findAll();
    }

    public Optional<PurchaseEntity> findById(Integer purchaseId) {
        return purchaseRepository.findById(purchaseId);
    }

    public void save(PurchaseEntity purchase) {
        purchaseRepository.save(purchase);
    }

    public void delete(PurchaseEntity purchase) {
        purchaseRepository.delete(purchase);
    }
}
