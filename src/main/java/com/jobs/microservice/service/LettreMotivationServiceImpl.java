package com.jobs.microservice.service;

import com.jobs.microservice.dao.LettreMotivationDao;
import com.jobs.microservice.model.LettreMotivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("lettreMotivationService")
public class LettreMotivationServiceImpl implements LettreMotivationService {

    private LettreMotivationDao lettreMotivationDao;

    @Autowired
    public LettreMotivationServiceImpl(LettreMotivationDao lettreMotivationDao) {
        this.lettreMotivationDao = lettreMotivationDao;
    }

    @Override
    public Optional<LettreMotivation> findById(Long idLettreMotivation) {
        return lettreMotivationDao.findById(idLettreMotivation);
    }

    @Override
    public List<LettreMotivation> findAll() {
        return lettreMotivationDao.findAll();
    }

    @Override
    public LettreMotivation save(LettreMotivation lettreMotivation) {
        return lettreMotivationDao.save(lettreMotivation);
    }
}
