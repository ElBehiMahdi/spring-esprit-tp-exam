package com.example.timeesheet.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class timesheet implements Serializable {

    @EmbeddedId
    private timesheetPK timesheetPK;

    @ManyToOne
    @JoinColumn(name = "idMission",referencedColumnName = "id",insertable = false,updatable = false)
    private mission mission;

    @ManyToOne
    @JoinColumn(name = "idEmployee",referencedColumnName = "id",insertable = false,updatable = false)
    private employee employee;

    private boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    public void setValide(boolean isValid) {
        this.isValid = isValid;
    }

    public timesheetPK getTimesheetPK() {
        return timesheetPK;
    }

    public void setTimesheetPK(timesheetPK timesheetPK) {
        this.timesheetPK = timesheetPK;
    }

    public mission getMission() {
        return mission;
    }

    public void setMission(mission mission) {
        this.mission = mission;
    }

    public employee getEmploye() {
        return employee;
    }

    public void setEmploye(employee employe) {
        this.employee = employe;
    }

}
