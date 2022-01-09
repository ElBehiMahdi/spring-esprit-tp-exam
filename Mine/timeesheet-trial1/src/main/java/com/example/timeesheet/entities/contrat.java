package com.example.timeesheet.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    private String typeContrat;

    private float salaire;

    @OneToOne
    private employee employee;

    public contrat() {
        super();
    }

    public contrat(Date dateDebut, String typeContrat, float salaire) {
        this.dateDebut = dateDebut;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public com.example.timeesheet.entities.employee getEmployee() {
        return employee;
    }

    public void setEmployee(com.example.timeesheet.entities.employee employee) {
        this.employee = employee;
    }
}
