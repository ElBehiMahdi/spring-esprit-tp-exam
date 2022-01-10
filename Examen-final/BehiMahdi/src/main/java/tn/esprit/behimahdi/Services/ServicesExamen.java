package tn.esprit.behimahdi.Services;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.behimahdi.Entities.*;

import java.util.Date;
import java.util.List;

public interface ServicesExamen {

    public Clinique addClinique(Clinique clinique);

    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);

    public Patient addPatient(Patient patient);

    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    public int getNbrRendezVousMedecin(Long idMedecin);

    public void retrieveRendezVous();

    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
