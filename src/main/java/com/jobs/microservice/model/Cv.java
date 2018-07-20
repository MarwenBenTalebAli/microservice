package com.jobs.microservice.model;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
public class Cv {

    @Id
    @GeneratedValue
    private Long idCv;
    @NotNull
    @Length(min=4, max=55)
    private String titre;
    @Length(min=13, max=55)
    private String objectif;

    @OneToMany(mappedBy = "cv")
    private Set<Formation> formations;
    @OneToMany(mappedBy = "cv")
    private Set<FormationPro> formationPros;
    @OneToMany(mappedBy = "cv")
    private Set<Experience> experiences;
    @OneToMany(mappedBy = "cv")
    private Set<Competence> competences;
    @ManyToOne
    @JoinColumn(name = "fk_candidat") //optionnel
    private Candidat candidat;

    @Column
    private LocalDateTime dateAjout;
    @Column
    private LocalDateTime dateModification;

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

    public Long getIdCv() {
        return idCv;
    }

    public void setIdCv(Long idCv) {
        this.idCv = idCv;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

    public Set<FormationPro> getFormationPros() {
        return formationPros;
    }

    public void setFormationPros(Set<FormationPro> formationPros) {
        this.formationPros = formationPros;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Cv() {
    }

    public Cv(String titre, String objectif) {
        this.titre = titre;
        this.objectif = objectif;
    }

}