package com.example.boutique.repos;

import com.example.boutique.entitites.centreCommercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface centreCommercialRepository extends JpaRepository<centreCommercial, Long> {
}
