package com.example.scrumexamen.repos;

import com.example.scrumexamen.entities.Project;
import com.example.scrumexamen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
