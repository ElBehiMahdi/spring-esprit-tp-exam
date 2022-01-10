package tn.esprit.spring.service;

import java.util.Date;

import tn.esprit.spring.entity.Formateur;

public interface FormateurService {
	public void AjouterFormateur(Formateur f);
	
	public Integer getFormateurRemu(Integer id,Date datedeb,Date datefin);
	

}
