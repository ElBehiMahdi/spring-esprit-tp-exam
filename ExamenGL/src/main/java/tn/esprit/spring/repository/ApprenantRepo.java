package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Apprenant;

@Repository
public interface ApprenantRepo extends CrudRepository<Apprenant, Long>{

}
