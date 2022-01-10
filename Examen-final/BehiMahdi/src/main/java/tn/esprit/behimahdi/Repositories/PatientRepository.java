package tn.esprit.behimahdi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.behimahdi.Entities.Clinique;
import tn.esprit.behimahdi.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
