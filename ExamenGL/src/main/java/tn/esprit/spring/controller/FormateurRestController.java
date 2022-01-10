package tn.esprit.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import tn.esprit.spring.service.FormateurServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Formateur management")
@RequestMapping("/formateurs")
public class FormateurRestController {
	@Autowired
	FormateurServiceImpl formateurS;
	@PostMapping("/add-formateur")
	@ResponseBody
	public void addFormateur(@RequestBody Formateur f)
	{
		formateurS.AjouterFormateur(f);
	
	}
	
	@GetMapping("/get-remu/{idFormateur}/{dateDeb}/{DateFin}/")
	@ResponseBody
	public Integer getRenu(@PathVariable("idFormateur") Integer idForma,@PathVariable("dateDeb")@DateTimeFormat(pattern="yyyy-MM-dd") Date dateDeb,
			@PathVariable("DateFin")@DateTimeFormat(pattern="yyyy-MM-dd") Date DateFin)
	{
		return formateurS.getFormateurRemu(idForma, dateDeb, DateFin);
	
	}

}
