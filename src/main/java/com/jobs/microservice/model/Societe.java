package com.jobs.microservice.model;

import com.jobs.microservice.enums.Categorie;
import com.jobs.microservice.enums.SecteurActivite;
import com.jobs.microservice.enums.TailleEntreprise;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity
public class Societe implements Serializable {
    @Id
    @GeneratedValue
    private Long idSociete;
    private String nomSociete;
    @Enumerated(EnumType.STRING)
    private SecteurActivite secteurActivite;
    @Enumerated(EnumType.STRING)
    private TailleEntreprise tailleEntreprise;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @OneToOne
    @JoinColumn(name = "fk_adresse")
    private Adresse adresse;
    private String siteWeb;

    @OneToMany(mappedBy = "societe")
    private Set<Emploi> emplois;

    public Societe() {
    }

    public Societe(String nomSociete, SecteurActivite secteurActivite, TailleEntreprise tailleEntreprise, Categorie categorie, Adresse adresse, String siteWeb) {
        this.nomSociete = nomSociete;
        this.secteurActivite = secteurActivite;
        this.tailleEntreprise = tailleEntreprise;
        this.categorie = categorie;
        this.adresse = adresse;
        this.siteWeb = siteWeb;
    }

    public Long getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Long idSociete) {
        this.idSociete = idSociete;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public SecteurActivite getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(SecteurActivite secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public TailleEntreprise getTailleEntreprise() {
        return tailleEntreprise;
    }

    public void setTailleEntreprise(TailleEntreprise tailleEntreprise) {
        this.tailleEntreprise = tailleEntreprise;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Set<Emploi> getEmplois() {
        return emplois;
    }

    public void setEmplois(Set<Emploi> emplois) {
        this.emplois = emplois;
    }

    public void addEmplois(Emploi emploi){
        this.emplois.add(emploi);
        emploi.setSociete(this);
    }
}