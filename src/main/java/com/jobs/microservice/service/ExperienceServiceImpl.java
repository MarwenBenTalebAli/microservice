package com.jobs.microservice.service;

import com.jobs.microservice.dao.ExperienceDao;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Experience;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ExperienceService")
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceDao experienceDao;

    public ExperienceServiceImpl(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public Optional<Experience> findById(Long idExperience) {
        return experienceDao.findById(idExperience);
    }

    @Override
    public List<Experience> findAll() {
        return experienceDao.findAll();
    }

    @Override
    public List<Experience> findByCv(Cv cv) {
        return experienceDao.findByCv(cv);
    }

    @Override
    public Experience save(Experience experience) {
        return experienceDao.save(experience);
    }

    @Override
    public void delete(Long idExperience) {
        experienceDao.deleteById(idExperience);
    }
}
