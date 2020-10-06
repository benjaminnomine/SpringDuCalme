package com.ducalme.app.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Paiement extends AbstractEntity {

    @ManyToOne
    private Locataire locataire;
    private Date datePaiement;
    private double montant;

    public Paiement(Locataire locataire, Date datePaiement, double montant) {
        this.locataire = locataire;
        this.datePaiement = datePaiement;
        this.montant = montant;
    }

    public Paiement() {
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
