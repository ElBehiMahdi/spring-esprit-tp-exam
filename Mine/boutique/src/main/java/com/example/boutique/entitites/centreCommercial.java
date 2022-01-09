package com.example.boutique.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class centreCommercial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String adresse;

    @Column
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "centreCommercial",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private List<boutique> boutiques;
}
