package com.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.repository.StudioDao;

@Service
public class StudioService {

	@Autowired
	private StudioDao studioDao;

	public void deleteStudioById(int id) {

		studioDao.deleteStudioById(id);
	}
}
