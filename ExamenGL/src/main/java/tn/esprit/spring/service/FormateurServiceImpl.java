package tn.esprit.spring.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Formateur;
import tn.esprit.spring.entity.Formation;
import tn.esprit.spring.repository.FormateurRepo;

@Service
public class FormateurServiceImpl implements FormateurService{
	@Autowired
	FormateurRepo Frepo;

	@Override
	public void AjouterFormateur(Formateur f) {
		// TODO Auto-generated method stub
		Frepo.save(f);
	}

	@Override
	public Integer getFormateurRemu(Integer id, Date datedeb, Date datefin) {
		// TODO Auto-generated method stub
		Formateur forma= Frepo.findById((long)id).orElse(null);
		Set<Formation> liste = new HashSet<>();
		liste = forma.getFormations();
		Integer total=0;
		for (Object element : liste) {
			Formation formation = (Formation) element;
			if(datedeb.before(formation.getDateDebut()) && datefin.after(formation.getDateFin()) )
			{
				Integer remu=formation.getNbrHeures()*forma.getTarifHoraire();
				total+=remu;
			}
			
		}
		
		return total;
	}

	
	

}
