package com.example.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Entreprise")
public class entreprise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEntreprise")
    private Long idEntreprise;

    private String name;

    private String raisonSocial;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
    private Set<departement> departements;
}
