package tn.esprit.behimahdi.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Patient")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //L'option AUTO-INCREMENT)
    @Column(name="idPatient")
    private Long idPatient; // Clé Primaire

    private String nomPatient;

    private Integer telephone;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<RendezVous> rendezVous;
}
