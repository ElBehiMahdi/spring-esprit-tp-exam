package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Formateur;

@Repository
public interface FormateurRepo  extends CrudRepository<Formateur, Long>{

}
