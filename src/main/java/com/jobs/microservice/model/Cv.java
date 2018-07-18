package com.jobs.microservice.model;

import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cv {

    @Id
    @GeneratedValue
    private Long idCv;
    private String titre;
    private String objectif;

    @OneToMany(mappedBy = "cv")
    private Set<Formation> formations;
    @OneToMany(mappedBy = "cv")
    private Set<FormationPro> formationPros;
    @OneToMany(mappedBy = "cv")
    private Set<Experience> experiences;
    @OneToMany(mappedBy = "cv")
    private Set<Competence> competences;
    @ManyToOne
    private Candidat candidat;

    public Cv() {
    }

    public Cv(String titre, String objectif) {
        this.titre = titre;
        this.objectif = objectif;
    }

}