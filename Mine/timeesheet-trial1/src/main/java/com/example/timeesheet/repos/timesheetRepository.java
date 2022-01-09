package com.example.timeesheet.repos;

import com.example.timeesheet.entities.timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface timesheetRepository extends JpaRepository<timesheet, Integer> {
}
