package com.ducalme.app.controller;

import com.ducalme.app.models.Reparation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository extends CrudRepository<Reparation, Integer> {
}
