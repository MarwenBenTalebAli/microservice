package com.jobs.microservice.model;

import com.jobs.microservice.enums.Niveau;

import javax.persistence.*;

import java.io.Serializable;


@Entity
public class Langue implements Serializable {
    @Id
    @GeneratedValue
    private Long idLangue;
    private String langue;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    public Langue() {
    }

    public Langue(String langue, Niveau niveau) {
        this.langue = langue;
        this.niveau = niveau;
    }

    public Long getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Long idLangue) {
        this.idLangue = idLangue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}