package com.example.timeesheet.controller;

import com.example.timeesheet.entities.mission;
import com.example.timeesheet.services.employeeService;
import com.example.timeesheet.services.entrepriseService;
import com.example.timeesheet.services.timesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RestControllerTimesheet {

    @Autowired
    employeeService iemployeservice;
    @Autowired
    entrepriseService ientrepriseservice;
    @Autowired
    timesheetService itimesheetservice;

    // http://localhost:8081/SpringMVC/servlet/ajouterMission
    // {"id":4,"name":"mamission", "description":"c ma mission"}
    @PostMapping("/ajouterMission")
    @ResponseBody
    public int ajouterMission(@RequestBody mission mission) {
        itimesheetservice.ajouterMission(mission);
        return mission.getId();
    }

    // http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
    @PutMapping(value = "/affecterMissionADepartement/{idmission}/{iddept}")
    public void affecterMissionADepartement(@PathVariable("idmission") int missionId, @PathVariable("iddept") int depId) {
        itimesheetservice.affecterMissionADepartement(missionId, depId);

    }

    // http://localhost:8081/SpringMVC/servlet/ajouterTimesheet
    //{"missionId":1,"employeId":2,"dateDebut":"2020-03-01","dateFin":"2021-03-01"}
    @PostMapping("/ajouterTimesheet/idmission/idemp/dated/datef")
    @ResponseBody
    public void ajouterTimesheet(@PathVariable("idmission") int missionId, @PathVariable("idemp") int employeId,
                                 @PathVariable("dated") Date dateDebut, @PathVariable("datef") Date dateFin) {
        itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);

    }
}
