package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Experience{

    @Id
    @GeneratedValue
    private Long idExperience;
    private String nomExperience;
    @ManyToOne
    private Cv cv;
}