package com.example.examen.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Timesheet")
public class timesheet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTimesheet")
    private Long idTimesheet;

    @Temporal (TemporalType.DATE)
    private Date dateDebut;

    @Temporal (TemporalType.DATE)
    private Date dateFin;

    private Boolean isValide;

}
