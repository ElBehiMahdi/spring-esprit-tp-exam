package tn.esprit.spring.service;

import tn.esprit.spring.entity.Formation;

public interface FormationService {
	public void ajouteretAffecterFormation(Formation f,Integer idFormateur);
	
	public void affecterApprenantFormation(Integer idApp,Integer idFormation);
	
	public void getNbrApprenantByFormation();
	
	public Integer getRevenuByFormation(Integer idFormation);

}
