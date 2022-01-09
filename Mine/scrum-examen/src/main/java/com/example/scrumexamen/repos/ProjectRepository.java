package com.example.scrumexamen.repos;

import com.example.scrumexamen.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT p FROM Project p join p.users u where u.id = :id")
    List<Project> projectByUser(@Param("id") int id);
}
