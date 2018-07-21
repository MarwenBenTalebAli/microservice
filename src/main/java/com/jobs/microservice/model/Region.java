package com.jobs.microservice.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity
public class Region implements Serializable {
    @Id
    @GeneratedValue
    private Long idRegion;
    private String nomRegion;
    @ManyToOne
    @JoinColumn(name = "fk_pays")
    private Pays pays;
    @OneToMany(mappedBy = "region")
    private Set<Ville> villes;

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Region() {
    }

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
