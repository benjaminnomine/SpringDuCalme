package com.ducalme.app.controller;

import com.ducalme.app.models.TypeAppartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAppartementRepository extends JpaRepository<TypeAppartement, Integer> {

}
