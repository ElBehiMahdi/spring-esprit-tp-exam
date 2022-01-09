package com.example.scrumexamen.services;

import com.example.scrumexamen.entities.Project;
import com.example.scrumexamen.entities.User;
import com.example.scrumexamen.repos.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public interface Services {
    public void addUser (User user);
    public void addProject (Project project);
    public void assignProjectToUser(int projectId, int userId);
    public List<Project> getAllProjects();
    public List<Project> getProjectsByUser(int userId);
    public void addSprintAndAssignToProject(String description, Date startDate, int idProject);

}
