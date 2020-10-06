package com.ducalme.app.controller;

import com.ducalme.app.models.Appartement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartementRepositery extends CrudRepository<Appartement, Integer> {
    public Appartement searchAppartementById(Integer id);
}
