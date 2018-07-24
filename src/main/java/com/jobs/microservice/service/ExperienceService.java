package com.jobs.microservice.service;

import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    Optional<Experience> findById(Long idExperience);
    List<Experience> findAll();
    List<Experience> findByCv(Cv cv);
    Experience save(Experience experience);
    void delete(Long idExperience);
}
