package com.example.examgestionarticles.controllers;


import com.example.examgestionarticles.entities.Article;
import com.example.examgestionarticles.entities.Categorie;
import com.example.examgestionarticles.entities.Commande;
import com.example.examgestionarticles.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/app")
public class RestController {

    @Autowired
    ServiceImpl service;

    @PostMapping("/addArticle")
    public void addArticle(@RequestBody Article article){
        service.ajouterArticle(article);
    }

    @PostMapping("/addCategorie")
    public void addCategorie(@RequestBody Categorie categorie){
        service.ajouterCategorie(categorie);
    }

    @PostMapping("/addCommande")
    public void addCommande(@RequestBody Commande commande){
        service.ajouterCommande(commande);
    }

    @GetMapping("/affecterArtCat/{idcat}/{idart}")
    public void affecterArtCat(@PathVariable("idcat")int idcat, @PathVariable("idart")int idart) {
        service.affecteArtCat(idcat,idart);
    }

    @GetMapping("/affecterArtCmd/{idcmd}/{idart}")
    public void affecterArtCmd(@PathVariable("idcmd")int idcmd, @PathVariable("idart")int idart) {
        service.affecterArtCmd(idcmd,idart);
    }

    @GetMapping("/getAllArticleNamesByCategorie/{idmacategorie}")
    public List<Article> getAllArticleNamesByCategorie(@PathVariable("idmacategorie")int idmacategorie) {
        return service.getAllArticleNamesByCategorie(idmacategorie);
    }

    @GetMapping("/getAllCategories")
    public List<String> getAllCategories() {
        return service.getAllCategories();
    }
}
