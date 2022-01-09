package com.example.timeesheet.repos;

import com.example.timeesheet.entities.entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface entrepriseRepository extends JpaRepository<entreprise, Integer> {
}
