package tn.esprit.behimahdi.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "RendezVous")
public class RendezVous implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //L'option AUTO-INCREMENT)
    @Column(name="idRDV")
    private Long idRDV; // Clé Primaire

    @Temporal(TemporalType.DATE)
    private Date dateRDV;

    private String remarque;

    @ManyToOne
    Medecin medecin;

    @ManyToOne
    Patient patient;
}
