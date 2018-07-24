package com.jobs.microservice.service;

import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.FormationPro;

import java.util.List;
import java.util.Optional;

public interface FormationProService {
    Optional<FormationPro> findById(Long idFormationPro);
    List<FormationPro> findAll();
    List<FormationPro> findByCv(Cv cv);
    FormationPro save(FormationPro formationPro);
    void delete(Long idFormationPro);
}
