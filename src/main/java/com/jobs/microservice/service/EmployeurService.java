package com.jobs.microservice.service;

import com.jobs.microservice.model.Employeur;

import java.util.List;
import java.util.Optional;

public interface EmployeurService {
    Optional<Employeur> findById(Long idEmployeur);

    List<Employeur> findAll();

    Employeur save(Employeur employeur);

    void delete(Long idEmployeur);
}
