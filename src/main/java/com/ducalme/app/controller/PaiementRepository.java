package com.ducalme.app.controller;

import com.ducalme.app.models.Paiement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends CrudRepository<Paiement, Integer> {
}
