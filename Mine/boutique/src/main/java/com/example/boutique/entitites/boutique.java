package com.example.boutique.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class boutique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nom;

    @Enumerated(EnumType.STRING)
    private categorie categorie;

    @ManyToOne
    private centreCommercial centreCommercial;

    @ManyToMany
    private List<client> clients;
}
