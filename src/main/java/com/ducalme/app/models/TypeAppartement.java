package com.ducalme.app.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeAppartement extends AbstractEntity {

    private String type;

    public TypeAppartement() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TypeAppartement(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "typeAppartement")
    public final List<Appartement> appartementList = new ArrayList<>();

    public List<Appartement> getAppartementList() {
        return appartementList;
    }
}
