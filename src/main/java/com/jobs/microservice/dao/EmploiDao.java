package com.jobs.microservice.dao;

import com.jobs.microservice.model.Emploi;
import com.jobs.microservice.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploiDao extends JpaRepository<Emploi, Long> {
    List<Emploi> findBySociete(Societe societe);
}
