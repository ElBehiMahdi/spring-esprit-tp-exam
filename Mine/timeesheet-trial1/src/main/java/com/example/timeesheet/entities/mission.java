package com.example.timeesheet.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    private departement departement;

    @ManyToMany
    private List<employee> employees;

    public mission() {
        super();
    }

    public mission(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.timeesheet.entities.departement getDepartement() {
        return departement;
    }

    public void setDepartement(com.example.timeesheet.entities.departement departement) {
        this.departement = departement;
    }

    public List<employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<employee> employees) {
        this.employees = employees;
    }
}
