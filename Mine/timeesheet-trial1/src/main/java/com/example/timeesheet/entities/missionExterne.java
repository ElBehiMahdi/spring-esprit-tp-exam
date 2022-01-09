package com.example.timeesheet.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class missionExterne extends mission {

    private String emailFacturation;

    private float tauxJournalierMoyen;

    public missionExterne() {
        super();
    }

    public missionExterne(String name, String description, String emailFacturation, float tauxJournalierMoyen) {
        super(name, description);
        this.emailFacturation = emailFacturation;
        this.tauxJournalierMoyen = tauxJournalierMoyen;
    }

    public String getEmailFacturation() {
        return emailFacturation;
    }

    public void setEmailFacturation(String emailFacturation) {
        this.emailFacturation = emailFacturation;
    }

    public float getTauxJournalierMoyen() {
        return tauxJournalierMoyen;
    }

    public void setTauxJournalierMoyen(float tauxJournalierMoyen) {
        this.tauxJournalierMoyen = tauxJournalierMoyen;
    }
}
