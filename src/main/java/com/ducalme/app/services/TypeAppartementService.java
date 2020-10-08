package com.ducalme.app.services;

import com.ducalme.app.models.Reparation;
import com.ducalme.app.controller.TypeAppartementRepository;
import com.ducalme.app.models.TypeAppartement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeAppartementService {
    private final TypeAppartementRepository typeAppartementRepository;

    public TypeAppartementService(TypeAppartementRepository typeAppartementRepository) {
        this.typeAppartementRepository = typeAppartementRepository;
    }

    public List<TypeAppartement> findAll() {
        return (List<TypeAppartement>) typeAppartementRepository.findAll();
    }

    public Optional<TypeAppartement> findById(Integer id) {
        return typeAppartementRepository.findById(id);
    }

    public TypeAppartement save(TypeAppartement locataire) {
        return typeAppartementRepository.save(locataire);
    }

    public void deleteById(Integer id) {
        typeAppartementRepository.deleteById(id);
    }
}
