package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;


@Entity
public class LettreMotivation{

    @Id
    @GeneratedValue
    private Long idLettreMotivation;
    private String titre;
    private String contenu;
}