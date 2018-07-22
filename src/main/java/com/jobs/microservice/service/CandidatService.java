package com.jobs.microservice.service;

import java.util.List;
import java.util.Optional;

import com.jobs.microservice.model.Candidat;

public interface CandidatService {
    Optional<Candidat> findById(Long idCandidat);
    List<Candidat> findAll();
    Candidat save(Candidat candidat);
    void delete(Long idCandidat);
}