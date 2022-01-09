package com.example.timeesheet.services;

import com.example.timeesheet.entities.contrat;
import com.example.timeesheet.entities.employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface employeeService {
    public int ajouterEmploye(employee employe);
    public void affecterEmployeADepartement(int employeId, int depId);
    public int ajouterContrat(contrat contrat);
    public void affecterContratAEmploye(int contratId, int employeId);
    public String getEmployePrenomById(int employeId);
    public long getNombreEmployeJPQL();
    public List<String> getAllEmployeNamesJPQL();
}
