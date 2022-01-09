package com.example.timeesheet.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prenom;

    private String nom;

    private String email;

    private boolean isActif;

    @Enumerated(EnumType.STRING)
    private role role;

    @ManyToMany(mappedBy = "employees")
    private List<departement> departements;

    @ManyToMany(mappedBy = "employees")
    private List<mission> missions;

    @OneToOne(mappedBy = "employee")
    private contrat contrat;

    public employee() {
        super();
    }

    public employee(String prenom, String nom, String email, boolean isActif, com.example.timeesheet.entities.role role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.isActif = isActif;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActif() {
        return isActif;
    }

    public void setActif(boolean actif) {
        isActif = actif;
    }

    public com.example.timeesheet.entities.role getRole() {
        return role;
    }

    public void setRole(com.example.timeesheet.entities.role role) {
        this.role = role;
    }

    public List<departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<departement> departements) {
        this.departements = departements;
    }

    public List<mission> getMissions() {
        return missions;
    }

    public void setMissions(List<mission> missions) {
        this.missions = missions;
    }

    public com.example.timeesheet.entities.contrat getContrat() {
        return contrat;
    }

    public void setContrat(com.example.timeesheet.entities.contrat contrat) {
        this.contrat = contrat;
    }
}
