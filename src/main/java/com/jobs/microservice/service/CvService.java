package com.jobs.microservice.service;

import java.util.List;
import java.util.Optional;

import com.jobs.microservice.model.Cv;

public interface CvService {
    Optional<Cv> findById(Long idCv);
    List<Cv> findAll();
    List<Cv> findByCandidat();
    Cv save(Cv cv);
}