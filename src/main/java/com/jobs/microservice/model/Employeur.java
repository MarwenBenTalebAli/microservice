package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;


@Entity
public class Employeur{

    @Id
    @GeneratedValue
    private Long idEmployeur;
}