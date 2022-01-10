package tn.esprit.behimahdi.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Clinique")
public class Clinique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //L'option AUTO-INCREMENT)
    @Column(name="idClinique")
    private Long idClinique; // Clé Primaire

    private String nomClinique;
    private String adresse;
    private Integer telephone;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Medecin> medecins;
}
