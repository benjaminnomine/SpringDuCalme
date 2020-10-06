package com.ducalme.app.models;


import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Locataire extends AbstractEntity {

    @NotNull
    public String nom;
    @NotNull
    public String prenom;

    public String telephone;

    @OneToMany(mappedBy = "locataire")
    private final List<Paiement> paiementList = new ArrayList<>();

    @OneToMany(mappedBy = "locataire")
    private final List<Bail> bailList = new ArrayList<>();

    public Locataire(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Locataire() { }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Bail> getBailList() { return bailList; }
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

}
