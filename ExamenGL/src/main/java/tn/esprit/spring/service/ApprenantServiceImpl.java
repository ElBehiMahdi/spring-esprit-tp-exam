package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Apprenant;
import tn.esprit.spring.repository.ApprenantRepo;

@Service
public class ApprenantServiceImpl implements ApprenantService{
	@Autowired
	ApprenantRepo appR;

	@Override
	public void AjouterAprenant(Apprenant app) {
		// TODO Auto-generated method stub
		appR.save(app);
		
	}

}
