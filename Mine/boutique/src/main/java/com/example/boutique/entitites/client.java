package com.example.boutique.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Enumerated(EnumType.STRING)
    private genre genre;

    @ManyToMany(mappedBy = "clients",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER)
    private List<boutique> boutiques;
}
