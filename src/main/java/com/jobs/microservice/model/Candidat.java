package com.jobs.microservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Candidat implements Serializable {
    @Id
    @GeneratedValue
    private Long idCandidat;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int age;
    private int genre;

    @OneToOne
    @JoinColumn(name = "fk_adresse")
    private Adresse adresse;

    @OneToMany(mappedBy = "candidat")
    private Collection<Cv> cvs;

    @OneToMany(mappedBy = "candidat")
    private Collection<LettreMotivation> lettreMotivations;

    @Column
    private LocalDateTime dateAjout;
    @Column
    private LocalDateTime dateModification;

    public Candidat() {
    }

    public Candidat(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }


    public Collection<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(Collection<Cv> cvs) {
        this.cvs = cvs;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
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



    public Collection<LettreMotivation> getLettreMotivations() {
        return lettreMotivations;
    }

    public void setLettreMotivations(Collection<LettreMotivation> lettreMotivations) {
        this.lettreMotivations = lettreMotivations;
    }

    public void addCvs(Cv cv){
        this.cvs.add(cv);
        cv.setCandidat(this);
    }

    public void addLettreMotivations(LettreMotivation lettreMotivation){
        this.lettreMotivations.add(lettreMotivation);
        lettreMotivation.setCandidat(this);
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}