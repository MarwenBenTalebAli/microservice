package com.jobs.microservice.service;

import java.util.List;

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
	public Cv findById(Long idCv) {
		return (Cv) cvDao.getOne(idCv);
	}

	@Override
	public List<Cv> findAll() {
		return (List<Cv>) cvDao.findAll();
	}
}