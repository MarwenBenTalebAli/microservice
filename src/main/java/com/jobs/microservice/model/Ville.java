package com.jobs.microservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;


@Entity
public class Ville {
    @Id
    @GeneratedValue
    private Long idVille;
    private String nom;
    private int codePostal;
    @ManyToOne
    private Region region;

    public Ville() {
    }

    public Ville(String nom, int codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
