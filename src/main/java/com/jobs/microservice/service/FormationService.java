package com.jobs.microservice.service;

import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {
    Optional<Formation> findById(Long idFormation);
    List<Formation> findAll();
    List<Formation> findByCv(Cv cv);
    Formation save(Formation formation);
    void delete(Long idFormation);
}
