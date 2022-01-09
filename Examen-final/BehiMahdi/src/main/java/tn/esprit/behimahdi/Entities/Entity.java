package tn.esprit.behimahdi.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@javax.persistence.Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Entity")
public class Entity implements Serializable {

    //Strategy = GenerationType.AUTO
    //Strategy = GenerationType.TABLE
    //Strategy = GenerationType.SEQUENCE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //L'option AUTO-INCREMENT)
    @Column(name="idClient")
    private Long idClient; // Clé Primaire

    private String nom;
    private String prenom;
    private String email;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Enumerated(EnumType.STRING)
    private EnumExample enumExample;

    // TIME : 30-09-19 10:50:56.780000000 AM
    // DATE : 30-09-19
    // TIMESTAMP : 1569840656 (nbre de secondes entre 01/01/1970 et la date voulue)
    @Temporal (TemporalType.DATE)
    private Date dateDebut;










    /*
	ONE TO ONE :
		One to one unidirectionelle 1 -> 1 :

			T_FORMATION (1)-->(1) T_FORMATION_DETAIL

				@Entity
				@Table(name = "T_FORMATION")
				public class Formation implements Serializable {

					@OneToOne
					private FormationDetail formationDetail;
				}


				@Entity
				@Table(name="T_FORMATION_DETAIL")
				public class FormationDetail implements Serializable {}

		One to one bidirectionelle 1 - 1 :

			T_FORMATION (1)-(1) T_FORMATION_DETAIL

				@Entity
				@Table(name = "T_FORMATION")
				public class Formation implements Serializable {

					@OneToOne
					private FormationDetail formationDetail;
				}

				@Entity
				@Table(name="T_FORMATION_DETAIL")
				public class FormationDetail implements Serializable {

					@OneToOne(mappedBy="formationDetail")
					private Formation formation;
				}

	ONE TO MANY :
		Unidirectionnelle :

			T_TP (1) --> (*) T_TP_CORRECTION

				@Entity
				@Table(name = "T_TP")
				public class TravauxPratiques implements Serializable {

					@OneToMany(cascade = CascadeType.ALL)
					private Set<TpCorrection> TpCorrections;
				}

				@Entity
				@Table(name="T_TP_CORRECTION")
				public class TpCorrection implements Serializable {}

		Bidirectionnelle :

			T_TP (1)-(*) T_TP_CORRECTION

				@Entity
				@Table(name = "T_TP")
				public class TravauxPratiques implements Serializable {

					@OneToMany(cascade = CascadeType.ALL, mappedBy="travauxPratiques")
					private Set<TpCorrection> TpCorrections;

				}

				@Entity
				@Table(name="T_TP_CORRECTION")
				public class TpCorrection implements Serializable {

					@ManyToOne
					TravauxPratiques travauxPratiques;
				}

	MANY TO ONE :
		Unidirectionnelle :

			T_TP_CORRECTION (1) --> (*) T_TP

				@Entity
				@Table(name = "T_TP_CORRECTION")
				public class TpCorrection implements Serializable {

					@ManyToOne(cascade = CascadeType.ALL)
					TravauxPratiques travauxPratiques;
				}

				@Entity
				@Table(name="T_TP")
				public class TravauxPratiques implements Serializable {}

		Bidirectionnelle :

			T_TP_CORRECTION (1)-(*) T_TP

				@Entity
				@Table(name = "T_TP_CORRECTION")
				public class TpCorrection implements Serializable {

					@ManyToOne
					TravauxPratiques travauxPratiques;

				}

				@Entity
				@Table(name="T_TP")
				public class TravauxPratiques implements Serializable {

					@OneToMany(cascade = CascadeType.ALL, mappedBy="travauxPratiques")
					private Set<TpCorrection> TpCorrections;

				}


	MANY TO MANY :
		Unidirectionnelle :

			T_FORMATION (*) --> (*) T_TP

				@Entity
				@Table(name = "T_FORMATION")
				public class Formation implements Serializable {

					@ManyToMany(cascade = CascadeType.ALL)
					private Set<TravauxPratiques> formationTps;
				}

				@Entity
				@Table(name="T_TP")
				public class TravauxPratiques implements Serializable {}

		Bidirectionnelle :

			T_FORMATION (*)-(*) T_TP

				@Entity
				@Table(name = "T_FORMATION")
				public class Formation implements Serializable {

					@ManyToMany(cascade = CascadeType.ALL)
					private Set<TravauxPratiques> formationTps;

				}

				@Entity
				@Table(name="T_TP")
				public class TravauxPratiques implements Serializable {

					@ManyToMany(mappedBy="formationTps", cascade = CascadeType.ALL)
					private Set<Formation> formations;

				}
     */
}
