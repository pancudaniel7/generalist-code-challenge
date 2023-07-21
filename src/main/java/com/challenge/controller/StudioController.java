package com.challenge.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.service.StudioService;

/**
 * Class which handles the endpoints for studio entity
 */
@RestController
@RequestMapping("/api/studio")
public class StudioController {
	private static Logger logger = LoggerFactory.getLogger(StudioController.class);

	@Autowired
	StudioService studioService;

	@DeleteMapping("delete/{id}")
	@Transactional
	public void deleteStudio(@PathVariable int id) {
		logger.info("[DELETE] - removing studio with id:" + id + " and it's associated games.");
		studioService.deleteStudioById(id);
	}
}
