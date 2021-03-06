package com.jobs.microservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


@Entity
public class Experience implements Serializable {

    @Id
    @GeneratedValue
    private Long idExperience;
    private String nomExperience;
    @ManyToOne
    @JoinColumn(name = "fk_cv") //optionnel
    private Cv cv;

    @Column
    private LocalDateTime dateDebut;
    @Column
    private LocalDateTime dateFin;
    @Column
    private
    Duration duree;
    @OneToOne
    @JoinColumn(name = "fk_adresse")
    private Adresse adresse;

    public Experience() {
    }

    public Experience(String nomExperience, LocalDateTime dateDebut, LocalDateTime dateFin, Adresse adresse) {
        this.nomExperience = nomExperience;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.adresse = adresse;
    }



    public Long getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Long idExperience) {
        this.idExperience = idExperience;
    }

    public String getNomExperience() {
        return nomExperience;
    }

    public void setNomExperience(String nomExperience) {
        this.nomExperience = nomExperience;
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

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}