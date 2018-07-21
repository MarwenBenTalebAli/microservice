package com.jobs.microservice.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Ville implements Serializable {
    @Id
    @GeneratedValue
    private Long idVille;
    private String nomVille;
    private int codePostal;
    @ManyToOne
    @JoinColumn(name = "fk_region")
    private Region region;

    public Ville() {
    }

    public Ville(String nomVille, int codePostal) {
        this.nomVille = nomVille;
        this.codePostal = codePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
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
