package com.jobs.microservice.service;

import java.util.List;
import java.util.Optional;

import com.jobs.microservice.dao.CvDao;
import com.jobs.microservice.model.Cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cvService")
public class CvServiceImpl implements CvService {

    private CvDao cvDao;

    @Autowired
	public CvServiceImpl(CvDao cvDao) {
		this.cvDao = cvDao;
    }

	@Override
	public Optional<Cv> findById(Long idCv) {
		return cvDao.findById(idCv);
	}

	@Override
	public List<Cv> findAll() {
		return cvDao.findAll();
	}

	@Override
	public List<Cv> findByCandidat() {
		return null;
	}

	@Override
	public Cv save(Cv cv) {
    	return cvDao.save(cv);
	}
}