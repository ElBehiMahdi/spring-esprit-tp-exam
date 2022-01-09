package com.example.dataacentre.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Datacenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDs;
    private String region;
    @Temporal(TemporalType.DATE)
    private Date dateFabriquation;
    private int capaciteDisque;
    private int espaceLibreDisque;

    @JsonIgnore
    @OneToMany(mappedBy="dataCenter", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    private List<VirtualMachine> vms;

}
