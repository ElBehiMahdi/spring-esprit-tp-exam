package com.example.timeesheet.repos;

import com.example.timeesheet.entities.departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departementRepository extends JpaRepository<departement,Integer> {
}
