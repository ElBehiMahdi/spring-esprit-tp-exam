package tn.esprit.behimahdi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.behimahdi.Entities.Clinique;
import tn.esprit.behimahdi.Entities.Patient;
import tn.esprit.behimahdi.Entities.RendezVous;
import tn.esprit.behimahdi.Entities.Specialite;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

    /*
    @Query("Select "
            + "RendezVous from RendezVous rdv "
            + "join Clinique clin "
            + "join Medecin med where clin.idClinique =: idc and med.specialite =: spec")
    public List<RendezVous> getRendevous(@Param("idc")Long idClinique, @Param("spec")Specialite specialite);
    */

    @Query("SELECT count(*) FROM RendezVous join Medecin m where m.idMedecin =: idMedecin")
    public int countrdv(@Param("idMedecin")Long idMedecin);

}
