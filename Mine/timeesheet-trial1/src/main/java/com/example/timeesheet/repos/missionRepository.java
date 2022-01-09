package com.example.timeesheet.repos;

import com.example.timeesheet.entities.mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface missionRepository extends JpaRepository<mission, Integer> {
}
