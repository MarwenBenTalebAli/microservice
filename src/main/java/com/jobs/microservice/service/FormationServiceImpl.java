package com.jobs.microservice.service;

import com.jobs.microservice.dao.FormationDao;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("formationService")
public class FormationServiceImpl implements FormationService {

    private FormationDao formationDao;

    @Autowired
    public FormationServiceImpl(FormationDao formationDao) {
        this.formationDao = formationDao;
    }

    @Override
    public Optional<Formation> findById(Long idFormation) {
        return formationDao.findById(idFormation);
    }

    @Override
    public List<Formation> findAll() {
        return formationDao.findAll();
    }

    @Override
    public List<Formation> findByCv(Cv cv) {
        return formationDao.findByCv(cv);
    }

    @Override
    public Formation save(Formation formation) {
        return formationDao.save(formation);
    }

    @Override
    public void delete(Long idFormation) {
        formationDao.deleteById(idFormation);
    }
}
