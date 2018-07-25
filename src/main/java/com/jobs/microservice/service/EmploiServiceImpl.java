package com.jobs.microservice.service;

import com.jobs.microservice.dao.EmploiDao;
import com.jobs.microservice.model.Emploi;
import com.jobs.microservice.model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmploiService")
public class EmploiServiceImpl implements EmploiService {
    private EmploiDao emploiDao;

    @Autowired
    public EmploiServiceImpl(EmploiDao emploiDao) {
        this.emploiDao = emploiDao;
    }

    @Override
    public Optional<Emploi> findById(Long idEmploi) {
        return emploiDao.findById(idEmploi);
    }

    @Override
    public List<Emploi> findAll() {
        return emploiDao.findAll();
    }

    @Override
    public List<Emploi> findBySociete(Societe societe) {
        return emploiDao.findBySociete(societe);
    }

    @Override
    public Emploi save(Emploi societe) {
        return emploiDao.save(societe);
    }

    @Override
    public void delete(Long idEmploi) {
        emploiDao.deleteById(idEmploi);
    }
}
