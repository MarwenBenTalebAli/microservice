package com.jobs.microservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Adresse implements Serializable {
    @Id
    @GeneratedValue
    private Long idAdresse;
    private int numRue;
    private String rue;

    @OneToOne
    @JoinColumn(name = "fk_pays")
    private Pays pays;
    @OneToOne
    @JoinColumn(name = "fk_region")
    private Region region;
    @OneToOne
    @JoinColumn(name = "fk_ville")
    private Ville ville;


    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Adresse() {
    }

    public Adresse(int numRue, String rue) {
        this.numRue = numRue;
        this.rue = rue;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }
}