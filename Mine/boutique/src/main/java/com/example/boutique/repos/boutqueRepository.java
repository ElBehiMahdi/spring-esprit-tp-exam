package com.example.boutique.repos;

import com.example.boutique.entitites.boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface boutqueRepository extends JpaRepository<boutique, Long> {
}
