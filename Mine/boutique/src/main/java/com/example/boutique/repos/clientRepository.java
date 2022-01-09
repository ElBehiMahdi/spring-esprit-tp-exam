package com.example.boutique.repos;

import com.example.boutique.entitites.client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<client, Long> {
}
