package com.jobs.microservice.dao;

import com.jobs.microservice.model.Competence;
import com.jobs.microservice.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Long> {
    List<Competence> findByCv(Cv cv);
}
