package com.jobs.microservice.service;

import com.jobs.microservice.model.Competence;
import com.jobs.microservice.model.Cv;

import java.util.List;
import java.util.Optional;

public interface CompetenceService {
    Optional<Competence> findById(Long idCompetence);

    List<Competence> findByCv(Cv cv);

    List<Competence> findAll();

    Competence save(Competence competence);

    void delete(Long idCompetence);
}