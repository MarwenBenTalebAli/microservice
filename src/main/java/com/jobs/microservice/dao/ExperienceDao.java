package com.jobs.microservice.dao;

import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceDao extends JpaRepository<Experience, Long> {
    List<Experience> findByCv(Cv cv);
}
