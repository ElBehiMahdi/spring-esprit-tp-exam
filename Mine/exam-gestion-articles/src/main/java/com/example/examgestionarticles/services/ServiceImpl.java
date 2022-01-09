package com.example.examgestionarticles.services;

import com.example.examgestionarticles.entities.Article;
import com.example.examgestionarticles.entities.Categorie;
import com.example.examgestionarticles.entities.Commande;
import com.example.examgestionarticles.entities.Status;
import com.example.examgestionarticles.repos.ArticleRepository;
import com.example.examgestionarticles.repos.CategorieRepository;
import com.example.examgestionarticles.repos.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.example.examgestionarticles.services.Service {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public void ajouterCategorie(Categorie cat) {
        categorieRepository.save(cat);
    }

    @Override
    public void ajouterArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void ajouterCommande(Commande c) {
        commandeRepository.save(c);
    }

    @Override
    public void affecteArtCat(int idcat, int idart) {
        Article article = articleRepository.getById(idart);
        Categorie categorie = categorieRepository.getById(idcat);

        article.setCategories(categorie);
        articleRepository.save(article);
    }

    @Override
    public void affecterArtCmd(int idcmd, int idart) {

    }

    @Override
    public List<Article> getAllArticleNamesByCategorie(int idmacategorie) {
        Categorie categorie = categorieRepository.findById(idmacategorie).orElse(null);
        return articleRepository.getAllArticleByCat(categorie.getNomcat());
    }

    @Override
    public List<String> getAllCategories() {
        return categorieRepository.catNames();
    }
}
