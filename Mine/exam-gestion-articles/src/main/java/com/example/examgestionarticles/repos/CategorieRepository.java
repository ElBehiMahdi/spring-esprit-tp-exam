package com.example.examgestionarticles.repos;

import com.example.examgestionarticles.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {


    @Query("SELECT nomcat FROM Categorie ")
    public List<String> catNames();
}
