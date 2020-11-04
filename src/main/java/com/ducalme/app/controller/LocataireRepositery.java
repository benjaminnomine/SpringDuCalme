package com.ducalme.app.controller;

import com.ducalme.app.models.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocataireRepositery extends JpaRepository<Locataire, Integer> {

    public Locataire searchLocataireById(Integer id);

}
