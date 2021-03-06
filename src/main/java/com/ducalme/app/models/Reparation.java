package com.ducalme.app.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Reparation extends AbstractEntity {

    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFinalisation;
    private String status;
    @ManyToOne
    private Appartement appartement;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateFinalisation() {
        return dateFinalisation;
    }

    public void setDateFinalisation(Date dateFinalisation) {
        this.dateFinalisation = dateFinalisation;
    }

    public Appartement getAppartement() {
        return appartement;
    }
}
