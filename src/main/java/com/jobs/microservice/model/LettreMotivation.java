package com.jobs.microservice.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
public class LettreMotivation {

    @Id
    @GeneratedValue
    private Long idLettreMotivation;
    @NotNull
    @Length(min = 4, max = 55)
    private String titre;
    @NotNull
    @Length(min = 4, max = 872)
    private String contenu;
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

    public LettreMotivation() {
    }

    public LettreMotivation(@NotNull @Length(min = 4, max = 55) String titre, @NotNull @Length(min = 4, max = 872) String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    public Long getIdLettreMotivation() {
        return idLettreMotivation;
    }

    public void setIdLettreMotivation(Long idLettreMotivation) {
        this.idLettreMotivation = idLettreMotivation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
}