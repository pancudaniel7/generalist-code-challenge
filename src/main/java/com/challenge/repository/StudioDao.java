package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.model.Studio;

/**
 * DAO(dataAccessObject) class used for working with data related to Studio entity
 */
@Repository
public interface StudioDao extends JpaRepository<Studio, String> {

	void deleteStudioById(int id);
}
