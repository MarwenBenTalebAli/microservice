package com.jobs.microservice.dao;

import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Formation;
import com.jobs.microservice.model.FormationPro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationProDao extends JpaRepository<FormationPro, Long> {
    List<FormationPro> findByCv(Cv cv);
}
