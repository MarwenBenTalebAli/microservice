package com.jobs.microservice.dao;

import com.jobs.microservice.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteDao extends JpaRepository<Societe, Long> {
}
