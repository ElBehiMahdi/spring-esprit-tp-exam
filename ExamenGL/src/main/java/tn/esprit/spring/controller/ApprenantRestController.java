package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Apprenant;
import tn.esprit.spring.entity.Formateur;
import tn.esprit.spring.service.ApprenantServiceImpl;
import tn.esprit.spring.service.FormateurServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "apprenant management")
@RequestMapping("/apprenants")
public class ApprenantRestController {
	@Autowired
	ApprenantServiceImpl appS;
	@PostMapping("/add-apprenant")
	@ResponseBody
	public void addApprenant(@RequestBody Apprenant app)
	{
		appS.AjouterAprenant(app);
	
	}

}


