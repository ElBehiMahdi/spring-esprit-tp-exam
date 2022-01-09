package com.example.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "Employe")
public class employe implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEmploye")
    private Long idEmploye;

    private String prenom;
    private String nom;
    private String email;
    private Boolean isActif;

    @Enumerated(EnumType.STRING)
    private role role;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<departement> departements;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<mission> missions;

    @OneToOne
    private contrat contrat;
}
