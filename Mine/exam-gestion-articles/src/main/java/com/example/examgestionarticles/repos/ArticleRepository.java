package com.example.examgestionarticles.repos;

import com.example.examgestionarticles.entities.Article;
import com.example.examgestionarticles.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select art from Article art where art.categories.nomcat =: category")
    public List<Article> getAllArticleByCat(@Param("category") String categorie);


}
