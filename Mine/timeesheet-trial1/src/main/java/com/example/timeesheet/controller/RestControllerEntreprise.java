package com.example.timeesheet.controller;

import com.example.timeesheet.entities.departement;
import com.example.timeesheet.entities.entreprise;
import com.example.timeesheet.services.employeeService;
import com.example.timeesheet.services.entrepriseService;
import com.example.timeesheet.services.timesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEntreprise {

    @Autowired
    employeeService iemployeservice;
    @Autowired
    entrepriseService ientrepriseservice;
    @Autowired
    timesheetService itimesheetservice;

    // Ajouter Entreprise : http://localhost:8081/SpringMVC/servlet/ajouterEntreprise
    //{"id":1,"name":"SSII Consulting","raisonSocial":"Cite El Ghazela"}
    @PostMapping("/ajouterEntreprise")
    @ResponseBody
    public int ajouterEntreprise(@RequestBody entreprise ssiiConsulting) {
        ientrepriseservice.ajouterEntreprise(ssiiConsulting);
        return ssiiConsulting.getId();
    }

    // http://localhost:8081/SpringMVC/servlet/affecterDepartementAEntreprise/1/1
    @PutMapping(value = "/affecterDepartementAEntreprise/{iddept}/{identreprise}")
    public void affecterDepartementAEntreprise(@PathVariable("iddept")int depId, @PathVariable("identreprise")int entrepriseId) {
        ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
    }

    // http://localhost:8081/SpringMVC/servlet/ajouterDepartement
    //{"id":1,"name":"Telecom"}

    @PostMapping("/ajouterDepartement")
    @ResponseBody
    public int ajouterDepartement(@RequestBody departement dep) {
        return ientrepriseservice.ajouterDepartement(dep);
    }

    //
    @GetMapping(value = "getAllDepartementsNamesByEntreprise/{identreprise}")
    @ResponseBody
    public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("identreprise") int entrepriseId) {
        return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
    }
}
