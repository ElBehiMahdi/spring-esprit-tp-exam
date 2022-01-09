package com.example.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Mission")
public class mission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMission")
    private Long idMission;

    private String name;

    private String description;

    @ManyToMany(mappedBy="missions", cascade = CascadeType.ALL)
    private Set<employe> employes;

    @ManyToOne
    departement departement;
}
