package com.airline.checkin.controllers;

import com.airline.checkin.models.PurchaseEntity;
import com.airline.checkin.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @CrossOrigin
    @GetMapping(path = "purchases")
    public Iterable<PurchaseEntity> findAll() {
        return purchaseService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "purchase/{purchaseId}")
    public Optional<PurchaseEntity> findById(@PathVariable("purchaseId") Integer purchaseId) {
        return purchaseService.findById(purchaseId);
    }

    @CrossOrigin
    @PostMapping(path = "purchase")
    public void save(@RequestBody PurchaseEntity purchase) {
        purchaseService.save(purchase);
    }

    @CrossOrigin
    @DeleteMapping(path = "purchase")
    public void delete(@RequestBody PurchaseEntity purchase) {
        purchaseService.delete(purchase);
    }
}
