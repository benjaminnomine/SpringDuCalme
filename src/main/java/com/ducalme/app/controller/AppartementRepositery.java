package com.ducalme.app.controller;

import com.ducalme.app.models.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartementRepositery extends JpaRepository<Appartement, Integer> {
    public Appartement searchAppartementById(Integer id);
}
