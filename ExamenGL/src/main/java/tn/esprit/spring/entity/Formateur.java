package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "Formateur")
public class Formateur {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//primary generate auto value
	@Column(name="idFormateur")
	private Long idFormateur; 
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="tarifHoraire")
	private Integer tarifHoraire;
	
	@Column(name="email")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "formateur")
	private Set<Formation> formations ;
	
	
	
	

}
