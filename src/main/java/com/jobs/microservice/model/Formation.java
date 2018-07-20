package com.jobs.microservice.model;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
public class Formation{

    @Id
    @GeneratedValue
    private Long idFormation;
    private String nomFormation;
    @OneToOne
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "fk_cv") //optionnel
    private Cv cv;

    @Column
    private LocalDateTime dateDebut;
    @Column
    private LocalDateTime dateFin;

    public Formation() {
    }

    public Formation(String nomFormation, Adresse adresse, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.nomFormation = nomFormation;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
}