package com.jobs.microservice.service;

import com.jobs.microservice.dao.EmployeurDao;
import com.jobs.microservice.model.Employeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmployeurService")
public class EmployeurServiceImpl implements EmployeurService {
    private EmployeurDao employeurDao;

    @Autowired
    public EmployeurServiceImpl(EmployeurDao employeurDao) {
        this.employeurDao = employeurDao;
    }

    @Override
    public Optional<Employeur> findById(Long idEmployeur) {
        return employeurDao.findById(idEmployeur);
    }

    @Override
    public List<Employeur> findAll() {
        return employeurDao.findAll();
    }

    @Override
    public Employeur save(Employeur employeur) {
        return employeurDao.save(employeur);
    }

    @Override
    public void delete(Long idEmployeur) {
        employeurDao.deleteById(idEmployeur);
    }
}
