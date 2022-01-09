package com.example.examgestionarticles.services;

import com.example.examgestionarticles.entities.Article;
import com.example.examgestionarticles.entities.Categorie;
import com.example.examgestionarticles.entities.Commande;

import java.util.List;

public interface Service {

    public void ajouterCategorie(Categorie cat);
    public void ajouterArticle(Article article);
    public void ajouterCommande(Commande c);
    public void affecteArtCat(int idcat,int idart);
    public void affecterArtCmd(int idcmd,int idart);
    public List<Article> getAllArticleNamesByCategorie(int idmacategorie);
    public List<String> getAllCategories();

}
