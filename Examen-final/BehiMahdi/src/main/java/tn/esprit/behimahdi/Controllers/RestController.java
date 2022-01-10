package tn.esprit.behimahdi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.behimahdi.Entities.*;
import tn.esprit.behimahdi.Services.ServiceExamenImpl;
import tn.esprit.behimahdi.Services.ServicesExamen;

import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/app")
public class RestController {

    @Autowired
    ServicesExamen serviceExamen;

    @PostMapping("/addClinique")
    @ResponseBody
    public void addClinique(@RequestBody Clinique clinique)
    {
        serviceExamen.addClinique(clinique);
    }

    @PostMapping("/addPatient")
    @ResponseBody
    public void addPatient(@RequestBody Patient patient)
    {
        serviceExamen.addPatient(patient);
    }

    @PostMapping("/addMedecinAndAssignToClinique/{cliniqueId}")
    @ResponseBody
    public void addMedecinAndAssignToClinique(@RequestBody Medecin medecin,@PathVariable("cliniqueId") Long cliniqueId) {

        serviceExamen.addMedecinAndAssignToClinique(medecin, cliniqueId);
    }


    public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
                                @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return 0;
    }

    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    @ResponseBody
    public List<RendezVous> getRevenu(@PathVariable("idClinique")Long idClinique, @PathVariable("specialite")Specialite specialite)
    {
        return serviceExamen.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("/retrieveRendezVous")
    @ResponseBody
    public void retrieveRendezVous()
    {
        serviceExamen.retrieveRendezVous();
    }

    /*
    @GetMapping("/GETrEV/{id}")
    @ResponseBody
    public void REV(@PathVariable("id")Long idMED @DateTimeFormat() Date startDate, Date endDate)
    {
        serviceExamen.getRevenuMedecin(idMED);
    }*/
}
