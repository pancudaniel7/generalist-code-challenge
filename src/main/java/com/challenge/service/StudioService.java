package com.challenge.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.repository.StudioDao;

@Service
public class StudioService {

	@Autowired
	private StudioDao studioDao;

	@Transactional
	public void deleteStudioById(int id) {

		studioDao.deleteStudioById(id);
	}
}
