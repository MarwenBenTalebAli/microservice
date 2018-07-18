package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

@Entity
public class Adresse {
    @Id
    @GeneratedValue
    private Long idAdresse;
    private int numRue;
    private String rue;


    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Adresse() {
    }

    public Adresse(int numRue, String rue) {
        this.numRue = numRue;
        this.rue = rue;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }
}