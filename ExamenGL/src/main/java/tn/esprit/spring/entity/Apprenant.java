package tn.esprit.spring.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table( name = "Apprenant")
public class Apprenant {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//primary generate auto value
	@Column(name="idApprenant")
	private Long idApprenant; 
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="telephone")
	private Integer telephone;
	
	@Column(name="email")
	private String email;
	
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Formation> formations = new HashSet<>();

}
