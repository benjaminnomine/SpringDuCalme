package com.ducalme.app.controller;

import com.ducalme.app.models.Locataire;
import org.springframework.data.repository.CrudRepository;

public interface LocataireRepositery extends CrudRepository<Locataire, Integer> {

    public Locataire searchLocataireById(Integer id);

}
