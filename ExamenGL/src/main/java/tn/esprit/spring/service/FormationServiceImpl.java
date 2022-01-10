package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Apprenant;
import tn.esprit.spring.entity.Formateur;
import tn.esprit.spring.entity.Formation;
import tn.esprit.spring.repository.ApprenantRepo;
import tn.esprit.spring.repository.FormateurRepo;
import tn.esprit.spring.repository.FormationRepo;

@Service

public class FormationServiceImpl implements FormationService{
	@Autowired
	FormationRepo Frepo;
	
	@Autowired
	FormateurRepo Formateurrepo;
	
	@Autowired
	ApprenantRepo Apprepo;
	@Override
	public void ajouteretAffecterFormation(Formation f, Integer idFormateur) {
		// TODO Auto-generated method stub
		Frepo.save(f);
		Formateur formateur= Formateurrepo.findById((long)idFormateur).orElse(null) ;
		Set<Formation> formations = formateur.getFormations();
		formations.add(f);
		formateur.setFormations(formations);
		f.setFormateur(formateur);
		Frepo.save(f);
		Formateurrepo.save(formateur);
		
		
	}
	@Override
	public void affecterApprenantFormation(Integer idApp, Integer idFormation) {
		// TODO Auto-generated method stub
		Apprenant app = Apprepo.findById((long)idApp).orElse(null);
		Formation formation = Frepo.findById((long)idFormation).orElse(null);
		Set<Apprenant> liste= formation.getApprenants();
		Integer nbrPartic=liste.size();
		System.out.println("lalalalala="+nbrPartic);
		if(formation.getNbrMaxParticipant()>nbrPartic)
		{
			liste.add(app);
			formation.setApprenants(liste);
			System.out.println("lalalalala="+formation.getApprenants());
			Set<Formation> liste2= app.getFormations();
			liste2.add(formation);
			app.setFormations(liste2);
			Apprepo.save(app);
			Frepo.save(formation);
		}
		
		
	}
	
	@Transactional
	@Scheduled(cron = "*/30 * * * * *" )
	public void getNbrApprenantByFormation() {
		// TODO Auto-generated method stub
		
		List<Formation> list = (List<Formation>) Frepo.findAll();
		Set<Formation> items = new HashSet<Formation>(list); 
		
		for (Object element : items) {
			Formation formation = (Formation) element;
			System.out.println("la formation :"+formation.getTitre() + "contient :"+formation.getApprenants().size()+" apprenants");
			
			
		}
		
	}
	@Override
	public Integer getRevenuByFormation(Integer idFormation) {
		// TODO Auto-generated method stub
		Formation f = Frepo.findById((long)idFormation).orElse(null);
		Integer revenu = f.getApprenants().size()*f.getFrais();
		return revenu;
	}

}
