package com.example.dataacentre.Repositories;

import com.example.dataacentre.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
}
