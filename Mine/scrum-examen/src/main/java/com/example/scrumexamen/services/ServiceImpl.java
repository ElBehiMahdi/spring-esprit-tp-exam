package com.example.scrumexamen.services;

import com.example.scrumexamen.entities.Project;
import com.example.scrumexamen.entities.Sprint;
import com.example.scrumexamen.entities.User;
import com.example.scrumexamen.repos.ProjectRepository;
import com.example.scrumexamen.repos.SprintRepository;
import com.example.scrumexamen.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiceImpl implements Services{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SprintRepository sprintRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project proj = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        Set<Project> set = new HashSet<>();
        set.add(proj);
        user.setProjects(set);
        userRepository.save(user);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getProjectsByUser(int userId) {
        return projectRepository.projectByUser(userId);
    }

    @Override
    public void addSprintAndAssignToProject(String description, Date startDate, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);

        Sprint sprint = new Sprint();

        sprint.setProject(project);
        sprint.setDescription(description);
        sprint.setStartDate(startDate);

        sprintRepository.save(sprint);
    }
}
