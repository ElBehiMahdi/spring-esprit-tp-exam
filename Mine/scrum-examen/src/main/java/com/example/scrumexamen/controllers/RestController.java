package com.example.scrumexamen.controllers;

import com.example.scrumexamen.entities.Project;
import com.example.scrumexamen.entities.User;
import com.example.scrumexamen.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/app")
public class RestController {

    @Autowired
    ServiceImpl service;

    @GetMapping("/retrieve-all-projects")
    @ResponseBody
    public List<Project> getAllProjects() {
        List<Project> list = service.getAllProjects();
        return list;
    }

    // http://localhost:8089/SpringMVC/client/retrieve-client/8
    @GetMapping("/retrieve-projectByUser/{user-id}")
    @ResponseBody
    public List<Project> getProjectsByUser(@PathVariable("user-id") int userId) {
        return service.getProjectsByUser(userId);
    }

    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-user")
    @ResponseBody
    public void adduser(@RequestBody User u) {
        service.addUser(u);
    }

    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-project")
    @ResponseBody
    public void addproject(@RequestBody Project p) {
        service.addProject(p);
    }

    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-sprint/{Description}/{startDate}/{idProj}")
    @ResponseBody
    public void addproject(@PathVariable("Description") String description, @PathVariable("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @PathVariable("idProj") int idProject ) {

        service.addSprintAndAssignToProject(description, startDate, idProject);
    }

    // http://localhost:8089/SpringMVC/client/modify-client
    @PutMapping("/assign-projectToUser/{project-id}/{user-id}")
    @ResponseBody
    public void assignProjectToUser(@PathVariable("project-id") int projectId,
                                    @PathVariable("user-id") int userId) {
        service.assignProjectToUser(projectId,userId);
    }
}
