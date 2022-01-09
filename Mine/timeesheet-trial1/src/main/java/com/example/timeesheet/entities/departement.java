package com.example.timeesheet.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    private List<employee> employees;

    @OneToMany(mappedBy = "departement")
    private List<mission> missions;

    @ManyToOne
    private entreprise entreprise;

    public departement() {
        super();
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

    public List<employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<employee> employees) {
        this.employees = employees;
    }

    public List<mission> getMissions() {
        return missions;
    }

    public void setMissions(List<mission> missions) {
        this.missions = missions;
    }

    public com.example.timeesheet.entities.entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(com.example.timeesheet.entities.entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
