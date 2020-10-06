package com.ducalme.app.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bail extends AbstractEntity {

    @ManyToOne
    private Locataire locataire;
    @ManyToOne
    private Appartement appartement;

    private Date dateSignature;
    private double duree;

    public Bail() {
    }

    public Bail(Locataire locataire, Appartement appartement, Date dateSignature, double duree) {
        this.locataire = locataire;
        this.appartement = appartement;
        this.dateSignature = dateSignature;
        this.duree = duree;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public Appartement getAppartement() {
        return appartement;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }
}
