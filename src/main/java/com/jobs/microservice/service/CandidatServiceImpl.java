package com.jobs.microservice.service;

import java.util.List;
import java.util.Optional;

import com.jobs.microservice.dao.CandidatDao;
import com.jobs.microservice.model.Candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("candidatService")
public class CandidatServiceImpl implements CandidatService {

    private CandidatDao candidatDao;

    @Autowired
    public CandidatServiceImpl(CandidatDao candidatDao) {
        this.candidatDao = candidatDao;
    }

    @Override
    public Optional<Candidat> findById(Long idCandidat) {
        return candidatDao.findById(idCandidat);
    }

    @Override
    public List<Candidat> findAll() {
        return candidatDao.findAll();
    }

    @Override
    public Candidat save(Candidat candidat) {
        return candidatDao.save(candidat);
    }
}