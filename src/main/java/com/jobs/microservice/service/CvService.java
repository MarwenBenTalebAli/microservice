package com.jobs.microservice.service;

import java.util.List;

import com.jobs.microservice.model.Cv;

public interface CvService {
    Cv findById(Long idCv);
    List<Cv> findAll();
}