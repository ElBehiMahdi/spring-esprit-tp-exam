package com.example.timeesheet.services;

import com.example.timeesheet.entities.contrat;
import com.example.timeesheet.entities.departement;
import com.example.timeesheet.entities.employee;
import com.example.timeesheet.repos.contratRepository;
import com.example.timeesheet.repos.departementRepository;
import com.example.timeesheet.repos.employeeRepository;
import com.example.timeesheet.repos.timesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class employeeServiceImpl implements employeeService {

    @Autowired
    employeeRepository employeeRepository;
    @Autowired
    departementRepository departementRepository;
    @Autowired
    contratRepository contratRepository;
    @Autowired
    timesheetRepository timesheetRepository;

    @Override
    public int ajouterEmploye(employee employe) {
        employeeRepository.save(employe);
        return employe.getId();
    }

    @Transactional
    public void affecterEmployeADepartement(int employeId, int depId) {
        departement depManagedEntity = departementRepository.findById(depId).get();
        employee employeeManagedEntity = employeeRepository.findById(employeId).get();

        if (depManagedEntity.getEmployees() == null){
            List<employee> employees = new ArrayList<>();
            employees.add(employeeManagedEntity);
            depManagedEntity.setEmployees(employees);
        }else {
            depManagedEntity.getEmployees().add(employeeManagedEntity);
        }
    }

    @Override
    public int ajouterContrat(contrat contrat) {
        contratRepository.save(contrat);
        return contrat.getReference();
    }

    @Override
    public void affecterContratAEmploye(int contratId, int employeId) {
        contrat contratManagedEntity = contratRepository.findById(contratId).get();
        employee employeManagedEntity = employeeRepository.findById(employeId).get();

        contratManagedEntity.setEmployee(employeManagedEntity);
        contratRepository.save(contratManagedEntity);
    }

    @Override
    public String getEmployePrenomById(int employeId) {
        employee employeManagedEntity = employeeRepository.findById(employeId).get();
        return employeManagedEntity.getPrenom();
    }

    @Override
    public long getNombreEmployeJPQL() {
        return employeeRepository.countemp();
    }

    @Override
    public List<String> getAllEmployeNamesJPQL() {
        return employeeRepository.employeNames();
    }
}
