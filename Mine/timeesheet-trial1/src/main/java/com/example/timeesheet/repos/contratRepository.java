package com.example.timeesheet.repos;

import com.example.timeesheet.entities.contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contratRepository extends JpaRepository<contrat, Integer> {

}
