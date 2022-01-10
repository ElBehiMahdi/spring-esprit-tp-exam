package tn.esprit.behimahdi.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.behimahdi.Entities.*;
import tn.esprit.behimahdi.Repositories.CliniqueRepository;
import tn.esprit.behimahdi.Repositories.MedecinRepository;
import tn.esprit.behimahdi.Repositories.PatientRepository;
import tn.esprit.behimahdi.Repositories.RendezVousRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ServiceExamenImpl implements ServicesExamen{

    @Autowired
    CliniqueRepository cliniqueRepository;

    @Autowired
    MedecinRepository medecinRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {

        /*
        medecinRepository.save(medecin);
        Clinique clinique = cliniqueRepository.findById((long)cliniqueId).orElse(null);
        Set<Clinique> CliniqueSet = new HashSet<>();
        CliniqueSet.add(clinique);
        Set<Medecin> Medecins = clinique.getMedecins();
        Medecins.add(medecin);
        clinique.setMedecins(Medecins);
        medecin.setCliniques(CliniqueSet);
        medecinRepository.save(medecin);
        cliniqueRepository.save(clinique);

        return medecin;
        */

        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);


        medecin.setCliniques((List<Clinique>) clinique);

        return medecinRepository.save(medecin);


    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {


    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        //return rendezVousRepository.getRendevous(idClinique, specialite);
        return null;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepository.countrdv(idMedecin);
    }

    public List<RendezVous> listerRendezVous() {
        return rendezVousRepository.findAll();
    }
    @Scheduled(cron="*/30 * * * * *")
    @Override
    public void retrieveRendezVous() {
        for (RendezVous rendezVous:listerRendezVous()){
            log.info("La liste des rdv :"+rendezVous.getDateRDV() +": Medecin :"+rendezVous.getMedecin().getNomMedecin()+": Patient :"+rendezVous.getPatient().getNomPatient());
        };
    }


    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        int solde = 0;
        Medecin m = this.medecinRepository.findById(idMedecin).orElse(null);

        if (m != null) {
            for (RendezVous rdv : m.getRendezVous()) {
                if (rdv.getDateRDV().after(startDate) && rdv.getDateRDV().before(endDate)) {
                    solde += m.getPrixConsultation() * m.getRendezVous().size();
                }
            }
            return solde;
        }
        return solde;
    }}

