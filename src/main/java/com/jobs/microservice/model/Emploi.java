package com.jobs.microservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Emploi implements Serializable {
    @Id
    @GeneratedValue
    private Long idEmploi;
    private String titre;
    private String description;
    private LocalDateTime dateAjout;
    private LocalDateTime dateModification;
    private LocalDateTime dateExpiration;
    @ManyToOne
    @JoinColumn(name = "fk_societe")
    private Societe societe;
    @OneToOne
    @JoinColumn(name = "fk_adresse")
    private Adresse adresse;

    public Emploi() {
    }

    public Emploi(String titre, String description, LocalDateTime dateAjout, Adresse adresse) {
        this.titre = titre;
        this.description = description;
        this.dateAjout = dateAjout;
        this.adresse = adresse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Long getIdEmploi() {
        return idEmploi;
    }

    public void setIdEmploi(Long idEmploi) {
        this.idEmploi = idEmploi;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }
}
