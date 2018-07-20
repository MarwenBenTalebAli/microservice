package com.jobs.microservice.service;

import com.jobs.microservice.model.LettreMotivation;

import java.util.List;
import java.util.Optional;

public interface LettreMotivationService {
    Optional<LettreMotivation> findById(Long idLettreMotivation);
    List<LettreMotivation> findAll();
    LettreMotivation save(LettreMotivation lettreMotivation);
}