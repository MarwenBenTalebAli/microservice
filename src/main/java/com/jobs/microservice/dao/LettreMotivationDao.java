package com.jobs.microservice.dao;

import com.jobs.microservice.model.LettreMotivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettreMotivationDao extends JpaRepository<LettreMotivation, Long> {
}
