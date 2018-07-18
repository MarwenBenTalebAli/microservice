package com.jobs.microservice.dao;

import com.jobs.microservice.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatDao extends JpaRepository<Candidat, Long> {
    Candidat findByIdCandidat(Long idCandidat);
}