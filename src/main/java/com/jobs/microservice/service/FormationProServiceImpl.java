package com.jobs.microservice.service;

import com.jobs.microservice.dao.FormationProDao;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.FormationPro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("FormationProService")
public class FormationProServiceImpl implements FormationProService {

    private FormationProDao formationProDao;

    public FormationProServiceImpl(FormationProDao formationProDao) {
        this.formationProDao = formationProDao;
    }

    @Override
    public Optional<FormationPro> findById(Long idFormation) {
        return formationProDao.findById(idFormation);
    }

    @Override
    public List<FormationPro> findAll() {
        return formationProDao.findAll();
    }

    @Override
    public List<FormationPro> findByCv(Cv cv) {
        return formationProDao.findByCv(cv);
    }

    @Override
    public FormationPro save(FormationPro FormationPro) {
        return formationProDao.save(FormationPro);
    }

    @Override
    public void delete(Long idFormationPro) {
        formationProDao.deleteById(idFormationPro);
    }
}
