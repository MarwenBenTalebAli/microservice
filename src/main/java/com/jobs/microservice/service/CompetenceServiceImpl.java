package com.jobs.microservice.service;

import com.jobs.microservice.dao.CompetenceDao;
import com.jobs.microservice.model.Competence;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CompetenceService")
public class CompetenceServiceImpl implements CompetenceService {
    private CompetenceDao competenceDao;

    @Autowired
    public CompetenceServiceImpl(CompetenceDao competenceDao) {
        this.competenceDao = competenceDao;
    }

    @Override
    public Optional<Competence> findById(Long idCompetence) {
        return competenceDao.findById(idCompetence);
    }

    @Override
    public List<Competence> findByCv(Cv cv) {
        return competenceDao.findByCv(cv);
    }

    @Override
    public List<Competence> findAll() {
        return competenceDao.findAll();
    }

    @Override
    public Competence save(Competence competence) {
        return competenceDao.save(competence);
    }

    @Override
    public void delete(Long idCompetence) {
        competenceDao.deleteById(idCompetence);
    }
}
