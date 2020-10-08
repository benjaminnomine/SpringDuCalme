package com.ducalme.app.controller;

import com.ducalme.app.models.Bail;
import com.ducalme.app.models.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BailRepository extends JpaRepository<Bail, Integer> {
    public Locataire searchBailById(Integer id);
}
