package com.example.examgestionarticles.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idart")
    private int idart;

    private String nom;

    private int prix;

    private String image;

    @ManyToOne
    Categorie categories;

    public Article(int idart, String nom, int prix, String image, Categorie categories) {
        this.idart = idart;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.categories = categories;
    }

    public Article() {
    }

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categorie getCategories() {
        return categories;
    }

    public void setCategories(Categorie categories) {
        this.categories = categories;
    }
}
