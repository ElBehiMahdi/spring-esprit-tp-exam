package tn.esprit.behimahdi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.behimahdi.Entities.Clinique;
import tn.esprit.behimahdi.Entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

}
