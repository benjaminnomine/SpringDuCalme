package com.ducalme.app.services;

import com.ducalme.app.controller.LocataireRepositery;
import com.ducalme.app.models.Locataire;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocataireService {

    private final LocataireRepositery locataireRepositery;

    public LocataireService(LocataireRepositery locataireRepositery) {
        this.locataireRepositery = locataireRepositery;
    }

    public List<Locataire> findAll() {
        return (List<Locataire>) locataireRepositery.findAll();
    }

    public Optional<Locataire> findById(Integer id) {
        return locataireRepositery.findById(id);
    }

    public Locataire save(Locataire locataire) {
        return locataireRepositery.save(locataire);
    }

    public void deleteById(Integer id) {
        locataireRepositery.deleteById(id);
    }
}
