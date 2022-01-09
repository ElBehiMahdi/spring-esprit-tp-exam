package com.example.timeesheet.controller;

import com.example.timeesheet.entities.employee;
import com.example.timeesheet.services.employeeService;
import com.example.timeesheet.services.entrepriseService;
import com.example.timeesheet.services.timesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEmployee {

    @Autowired
    employeeService iemployeservice;
    @Autowired
    entrepriseService ientrepriseservice;
    @Autowired
    timesheetService itimesheetservice;

    // http://localhost:8081/SpringMVC/servlet/ajouterEmployer
    //{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}
    @PostMapping("/ajouterEmployer")
    @ResponseBody
    public employee ajouterEmploye(@RequestBody employee employe)
    {
        iemployeservice.ajouterEmploye(employe);
        return employe;
    }

    // http://localhost:8081/SpringMVC/servlet/affecterEmployeADepartement/1/1
    @PutMapping(value = "/affecterEmployeADepartement/{idemp}/{iddept}")
    public void affecterEmployeADepartement(@PathVariable("idemp")int employeId, @PathVariable("iddept")int depId) {
        iemployeservice.affecterEmployeADepartement(employeId, depId);

    }

    // http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye/6/1
    @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}")
    public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int employeId)
    {
        iemployeservice.affecterContratAEmploye(contratId, employeId);
    }



    // URL : http://localhost:8081/SpringMVC/servlet/getEmployePrenomById/2
    @GetMapping(value = "getEmployePrenomById/{idemp}")
    @ResponseBody
    public String getEmployePrenomById(@PathVariable("idemp")int employeId) {
        return iemployeservice.getEmployePrenomById(employeId);
    }

    // URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
    @GetMapping(value = "getNombreEmployeJPQL")
    @ResponseBody
    public int getNombreEmployeJPQL() {

        return (int) iemployeservice.getNombreEmployeJPQL();
    }

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeNamesJPQL
    @GetMapping(value = "getAllEmployeNamesJPQL")
    @ResponseBody
    public List<String> getAllEmployeNamesJPQL() {

        return iemployeservice.getAllEmployeNamesJPQL();
    }
}
