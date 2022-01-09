package com.example.timeesheet.services;

import com.example.timeesheet.entities.mission;
import org.springframework.stereotype.Service;

import java.util.Date;

public interface timesheetService {
    public int ajouterMission(mission mission);
    public void affecterMissionADepartement(int missionId, int depId);
    public void ajouterTimesheet(int missionId, int employeId, Date
            dateDebut, Date dateFin);

}
