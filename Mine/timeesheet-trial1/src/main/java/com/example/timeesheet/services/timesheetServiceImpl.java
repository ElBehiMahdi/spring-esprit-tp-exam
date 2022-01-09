package com.example.timeesheet.services;

import com.example.timeesheet.entities.departement;
import com.example.timeesheet.entities.mission;
import com.example.timeesheet.entities.timesheet;
import com.example.timeesheet.entities.timesheetPK;
import com.example.timeesheet.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class timesheetServiceImpl implements timesheetService{

    @Autowired
    employeeRepository employeeRepository;
    @Autowired
    departementRepository departementRepository;
    @Autowired
    contratRepository contratRepository;
    @Autowired
    timesheetRepository timesheetRepository;
    @Autowired
    missionRepository missionRepository;

    @Override
    public int ajouterMission(mission mission) {
        missionRepository.save(mission);
        return mission.getId();
    }

    @Override
    public void affecterMissionADepartement(int missionId, int depId) {
        mission mission = missionRepository.findById(missionId).get();
        departement dep = departementRepository.findById(depId).get();
        mission.setDepartement(dep);
        missionRepository.save(mission);
    }

    @Override
    public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
        timesheetPK timesheetPK = new timesheetPK();
        timesheetPK.setDateDebut(dateDebut);
        timesheetPK.setDateFin(dateFin);
        timesheetPK.setIdEmploye(employeId);
        timesheetPK.setIdMission(missionId);

        timesheet timesheet = new timesheet();
        timesheet.setTimesheetPK(timesheetPK);
        timesheet.setValide(false); //par defaut non valide
        timesheetRepository.save(timesheet);
    }
}
