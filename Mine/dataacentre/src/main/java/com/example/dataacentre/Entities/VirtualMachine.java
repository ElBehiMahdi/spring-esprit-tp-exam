package com.example.dataacentre.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VirtualMachine implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVm;
    private String os;
    private int tailleDisque;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    private Datacenter dataCenter;

}
