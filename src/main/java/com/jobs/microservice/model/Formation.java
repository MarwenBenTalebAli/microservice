package com.jobs.microservice.model;

import java.util.Set;

import javax.persistence.*;


@Entity
public class Formation{

    @Id
    @GeneratedValue
    private Long idFormation;
    private String nomFormation;
    @OneToOne
    private Adresse adresse;
    @ManyToOne
    private Cv cv;

}