package com.jobs.microservice.dao;

import com.jobs.microservice.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvDao extends JpaRepository<Cv, Long> {
}