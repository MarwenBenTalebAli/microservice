package com.jobs.microservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import java.util.Set;


@Entity
public class Region {
    @Id
    @GeneratedValue
    private Long idRegion;
    private String nomRegion;

    @ManyToOne
    private Pays pays;
    @OneToMany(mappedBy = "region")
    private Set<Ville> villes;

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public Set<Ville> getVilles() {
        return villes;
    }

    public void setVilles(Set<Ville> villes) {
        this.villes = villes;
    }
}
