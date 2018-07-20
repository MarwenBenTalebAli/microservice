package com.jobs.microservice.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;


@Entity
public class FormationPro{
    @Id
    @GeneratedValue
    private Long idFormationPro;
    private String nomFormationPro;
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

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    public FormationPro() {
    }

    public FormationPro(String nomFormationPro, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.nomFormationPro = nomFormationPro;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Long getIdFormationPro() {
        return idFormationPro;
    }

    public void setIdFormationPro(Long idFormationPro) {
        this.idFormationPro = idFormationPro;
    }

    public String getNomFormationPro() {
        return nomFormationPro;
    }

    public void setNomFormationPro(String nomFormationPro) {
        this.nomFormationPro = nomFormationPro;
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