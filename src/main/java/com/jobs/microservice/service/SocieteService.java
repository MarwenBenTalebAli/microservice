package com.jobs.microservice.service;

import com.jobs.microservice.model.Societe;

import java.util.List;
import java.util.Optional;

public interface SocieteService {
    Optional<Societe> findById(Long idSociete);

    List<Societe> findAll();

    Societe save(Societe societe);

    void delete(Long idSociete);
}
