package com.example.timeesheet.entities;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class timesheetPK implements Serializable {

    private int idMission;

    private int idEmployee;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    public timesheetPK() {
        super();
    }

    public timesheetPK(int idMission, int idEmployee, Date dateDebut, Date dateFin) {
        super();
        this.idMission = idMission;
        this.idEmployee = idEmployee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
        result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
        result = prime * result + idEmployee;
        result = prime * result + idMission;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        timesheetPK other = (timesheetPK) obj;
        if (dateDebut == null) {
            if (other.dateDebut != null)
                return false;
        } else if (!dateDebut.equals(other.dateDebut))
            return false;
        if (dateFin == null) {
            if (other.dateFin != null)
                return false;
        } else if (!dateFin.equals(other.dateFin))
            return false;
        if (idEmployee != other.idEmployee)
            return false;
        if (idMission != other.idMission)
            return false;
        return true;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public int getIdEmploye() {
        return idEmployee;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmployee = idEmploye;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdMission() {
        return idMission;
    }

}
