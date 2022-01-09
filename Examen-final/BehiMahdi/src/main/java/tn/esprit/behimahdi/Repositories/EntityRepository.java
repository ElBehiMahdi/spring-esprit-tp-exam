package tn.esprit.behimahdi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.behimahdi.Entities.Entity;

public interface EntityRepository extends JpaRepository<Entity, Long> {
    //JPQL code here
}
