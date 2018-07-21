package com.jobs.microservice.model;

import javax.persistence.*;

import java.io.Serializable;


@Entity
public class Employeur implements Serializable {

    @Id
    @GeneratedValue
    private Long idEmployeur;
    private String nomEmployeur;
    private String prenomEmployeur;
    @OneToOne
    @JoinColumn(name = "fk_societe")
    private Societe societe;

    public Employeur() {
    }

    public Employeur(String nomEmployeur, String prenomEmployeur, Societe societe) {
        this.nomEmployeur = nomEmployeur;
        this.prenomEmployeur = prenomEmployeur;
        this.societe = societe;
    }

    public Long getIdEmployeur() {
        return idEmployeur;
    }

    public void setIdEmployeur(Long idEmployeur) {
        this.idEmployeur = idEmployeur;
    }

    public String getNomEmployeur() {
        return nomEmployeur;
    }

    public void setNomEmployeur(String nomEmployeur) {
        this.nomEmployeur = nomEmployeur;
    }

    public String getPrenomEmployeur() {
        return prenomEmployeur;
    }

    public void setPrenomEmployeur(String prenomEmployeur) {
        this.prenomEmployeur = prenomEmployeur;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }
}