package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table( name = "Formation")
public class Formation {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//primary generate auto value
	@Column(name="idFormation")
	private Long idFormation; 
	
	@Column(name="titre")
	private String titre;
	
	@Enumerated(EnumType.STRING)
	@Column(name="niveau")
	private Niveau niveau;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateDebut")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateFin")
	private Date dateFin;
	
	@Column(name="nbrHeures")
	private Integer nbrHeures;
	
	@Column(name="nbrMaxParticipant")
	private Integer nbrMaxParticipant;
	
	@Column(name="frais")
	private Integer frais;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "formations")
	private Set<Apprenant> apprenants;
	
	@JsonIgnore
	@ManyToOne
	private Formateur formateur;
	
	
	
	
	
}
