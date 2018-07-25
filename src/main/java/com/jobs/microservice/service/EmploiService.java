package com.jobs.microservice.service;

import com.jobs.microservice.model.Emploi;
import com.jobs.microservice.model.Societe;

import java.util.List;
import java.util.Optional;

public interface EmploiService {
    Optional<Emploi> findById(Long idEmploi);

    List<Emploi> findAll();

    List<Emploi> findBySociete(Societe societe);

    Emploi save(Emploi emploi);

    void delete(Long idEmploi);
}
