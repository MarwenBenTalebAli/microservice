package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Competence{
    @Id
    @GeneratedValue
    private Long idCompetence;
    private String nomCompetence;
    private int niveau;
    @ManyToOne
    private Cv cv;

    public Competence() {
    }

    public Competence(String nomCompetence, int niveau) {
        this.nomCompetence = nomCompetence;
        this.niveau = niveau;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}