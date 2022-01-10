package tn.esprit.behimahdi.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Medecin")
public class Medecin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //L'option AUTO-INCREMENT)
    @Column(name="idMedecin")
    private Long idMedecin; // Clé Primaire

    private String nomMedecin;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;


    private Integer telephone;

    private Integer prixConsultation;

    @ManyToMany(mappedBy="medecins", cascade = CascadeType.ALL)
    private List<Clinique> cliniques;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="medecin")
    private List<RendezVous> rendezVous;

}
