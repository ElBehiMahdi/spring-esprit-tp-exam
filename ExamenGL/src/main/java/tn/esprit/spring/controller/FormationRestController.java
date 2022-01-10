package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Formateur;
import tn.esprit.spring.entity.Formation;
import tn.esprit.spring.service.FormateurServiceImpl;
import tn.esprit.spring.service.FormationServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Formation management")
@RequestMapping("/formations")
public class FormationRestController {
	@Autowired
	FormationServiceImpl formationS;
	@PostMapping("/add-formation/{formateur-id}")
	@ResponseBody
	public void addFormateur(@RequestBody Formation f,@PathVariable("formateur-id")Integer idFormateur)
	{
		formationS.ajouteretAffecterFormation(f, idFormateur);
	
	}
	
	@PostMapping("/affecter-formation/{formation-id}/{apprenant-id}")
	@ResponseBody
	public void affecterApprenantFormation(@PathVariable("formation-id")Integer idFormation,@PathVariable("apprenant-id")Integer idapprenant)
	{
		formationS.affecterApprenantFormation(idapprenant, idFormation);
	
	}
	
	@GetMapping("/revenu-formation/{formation-id}")
	@ResponseBody
	public Integer getRevenu(@PathVariable("formation-id")Integer idFormation)
	{
		return formationS.getRevenuByFormation(idFormation);
	
	}

}
