package com.example.timeesheet.services;

import com.example.timeesheet.entities.departement;
import com.example.timeesheet.entities.entreprise;
import com.example.timeesheet.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class entrepriseServiceImpl implements entrepriseService{

    @Autowired
    employeeRepository employeeRepository;
    @Autowired
    departementRepository departementRepository;
    @Autowired
    contratRepository contratRepository;
    @Autowired
    timesheetRepository timesheetRepository;
    @Autowired
    entrepriseRepository entrepriseRepoistory;
    @Autowired
    departementRepository deptRepoistory;

    @Override
    public int ajouterEntreprise(entreprise entreprise) {
        entrepriseRepoistory.save(entreprise);
        return entreprise.getId();
    }

    @Override
    public int ajouterDepartement(departement dep) {
        deptRepoistory.save(dep);
        return dep.getId();
    }

    @Transactional
    public void affecterDepartementAEntreprise(int depId, int entrepriseId) {

        //see departement and entreprise, see which is slave and which is master, master is N, slave is 1, we always set slave to master

        entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
        departement depManagedEntity = departementRepository.findById(depId).get();

        depManagedEntity.setEntreprise(entrepriseManagedEntity);
        deptRepoistory.save(depManagedEntity);
    }

    public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
        entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();

        List<String> names = new ArrayList<>();

        for (departement dep:entrepriseManagedEntity.getDepartements()){
            names.add(dep.getName());
        }

        return names;
    }


}
