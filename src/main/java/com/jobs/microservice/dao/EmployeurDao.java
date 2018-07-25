package com.jobs.microservice.dao;

import com.jobs.microservice.model.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeurDao extends JpaRepository<Employeur, Long> {
}
