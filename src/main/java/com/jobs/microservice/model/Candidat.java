package com.jobs.microservice.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Candidat {
    @Id
    @GeneratedValue
    private Long idCandidat;
    private String nom;
    private String prenom;
    private int age;
    @OneToMany
    private Collection<Cv> cvs;
    @OneToMany
    private Collection<LettreMotivation> lettreMotivations;

    public Candidat() {
    }

    public Candidat(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Long getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Long idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(Collection<Cv> cvs) {
        this.cvs = cvs;
    }

    public Collection<LettreMotivation> getLettreMotivations() {
        return lettreMotivations;
    }

    public void setLettreMotivations(Collection<LettreMotivation> lettreMotivations) {
        this.lettreMotivations = lettreMotivations;
    }
}