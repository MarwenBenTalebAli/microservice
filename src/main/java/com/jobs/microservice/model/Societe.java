package com.jobs.microservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;


@Entity
public class Societe{
    @Id
    @GeneratedValue
    private Long idSociete;
}