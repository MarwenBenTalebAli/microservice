package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class FormationPro{
    @Id
    @GeneratedValue
    private Long idFormationPro;
    private String nomFormationPro;
    @ManyToOne
    private Cv cv;
}