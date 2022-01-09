package com.example.timeesheet.repos;

import com.example.timeesheet.entities.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeRepository extends JpaRepository<employee, Integer> {
    @Query("SELECT count(*) FROM employee ")
    public int countemp();

    @Query("SELECT nom FROM employee ")
    public List<String> employeNames();
}
