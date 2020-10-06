package com.ducalme.app.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Appartement extends AbstractEntity {

    public String description;
    public double surface;

    @ManyToOne
    public TypeAppartement typeAppartement;

    @OneToMany(mappedBy = "appartement")
    private final List<Bail> bailList = new ArrayList<>();

    @OneToMany(mappedBy = "appartement")
    private final List<Reparation> reparationList = new ArrayList<>();

    public Appartement(String description, double surface, TypeAppartement typeAppartement) {
        this.description = description;
        this.surface = surface;
        this.typeAppartement = typeAppartement;
    }

    public Appartement() { }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public TypeAppartement getTypeAppartement() {
        return typeAppartement;
    }

    public void setTypeAppartement(TypeAppartement typeAppartement) {
        this.typeAppartement = typeAppartement;
    }

    public List<Bail> getBailList() {
        return bailList;
    }

    public List<Reparation> getReparationList() {
        return reparationList;
    }
}
