package com.example.scrumexamen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    @ManyToMany(mappedBy="projects", cascade = CascadeType.ALL)
    private Set<User> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="project")
    private Set<Sprint> sprints;
}
