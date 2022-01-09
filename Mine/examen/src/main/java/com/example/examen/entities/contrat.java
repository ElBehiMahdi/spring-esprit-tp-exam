package com.example.examen.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Contrat")
public class contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat;

    private String reference;
    @Temporal (TemporalType.DATE)
    private Date dateDebut;

    private String typeContrat;

    private Float salaire;

    @OneToOne(mappedBy="contrat")
    private employe employe;

}
