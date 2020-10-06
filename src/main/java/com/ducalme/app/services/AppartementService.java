package com.ducalme.app.services;

import com.ducalme.app.controller.AppartementRepositery;
import com.ducalme.app.models.Appartement;

import java.util.List;
import java.util.Optional;

public class AppartementService {

    private final AppartementRepositery appartementRepositery;

    public AppartementService(AppartementRepositery appartementRepositery) {
        this.appartementRepositery = appartementRepositery;
    }

    public List<Appartement> findAll() {
        return (List<Appartement>) appartementRepositery.findAll();
    }

    public Optional<Appartement> findById(Integer id) {
        return appartementRepositery.findById(id);
    }

    public Appartement save(Appartement appartement) {
        return appartementRepositery.save(appartement);
    }

    public void deleteById(Integer id) {
        appartementRepositery.deleteById(id);
    }
}
