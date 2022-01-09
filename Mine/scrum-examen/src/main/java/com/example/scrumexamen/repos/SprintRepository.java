package com.example.scrumexamen.repos;

import com.example.scrumexamen.entities.Project;
import com.example.scrumexamen.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {
}
