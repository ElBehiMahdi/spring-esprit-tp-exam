package com.example.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Departement")
public class departement implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idDept")
    private Long idDept;

    private String name;

    @ManyToMany(mappedBy="departements", cascade = CascadeType.ALL)
    private Set<employe> employes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private Set<mission> missions;

    @ManyToOne
    entreprise entreprise;
}
