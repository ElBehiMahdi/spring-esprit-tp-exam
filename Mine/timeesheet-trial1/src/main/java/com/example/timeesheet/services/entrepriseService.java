package com.example.timeesheet.services;

import com.example.timeesheet.entities.departement;
import com.example.timeesheet.entities.entreprise;
import org.springframework.stereotype.Service;

import java.util.List;

public interface entrepriseService {
    public int ajouterEntreprise(entreprise entreprise);
    public int ajouterDepartement(departement dep);
    void affecterDepartementAEntreprise(int depId, int entrepriseId);
    List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);

}
