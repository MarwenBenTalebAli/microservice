package com.jobs.microservice.service;

import com.jobs.microservice.dao.SocieteDao;
import com.jobs.microservice.model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("societeService")
public class SocieteServiceImpl implements SocieteService {

    private SocieteDao societeDao;

    @Autowired
    public SocieteServiceImpl(SocieteDao societeDao) {
        this.societeDao = societeDao;
    }

    @Override
    public Optional<Societe> findById(Long idSociete) {
        return societeDao.findById(idSociete);
    }

    @Override
    public List<Societe> findAll() {
        return societeDao.findAll();
    }

    @Override
    public Societe save(Societe societe) {
        return societeDao.save(societe);
    }

    @Override
    public void delete(Long idSociete) {
        societeDao.deleteById(idSociete);
    }
}
