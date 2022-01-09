package com.example.examenfinal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

public interface EntityRepository extends JpaRepository<Entity, Long> {
    //JPQL code here
}
