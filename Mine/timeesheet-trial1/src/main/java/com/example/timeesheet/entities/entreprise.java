package com.example.timeesheet.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class entreprise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String raisonSocial;

    @OneToMany(mappedBy = "entreprise", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<departement> departements = new ArrayList<>();

    public entreprise() {
        super();
    }

    public entreprise(String name, String raisonSocial) {
        this.name = name;
        this.raisonSocial = raisonSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public List<departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<departement> departements) {
        this.departements = departements;
    }
}
