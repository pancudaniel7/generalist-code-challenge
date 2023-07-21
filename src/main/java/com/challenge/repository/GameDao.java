package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.model.Game;

/**
 * DAO(dataAccessObject) class used for working with data related to Game entity
 */
@Repository
public interface GameDao extends JpaRepository<Game, Integer> {

	Optional<List<Game>> findGamesByStudioKey(int studio);
	Optional<Game> findGamesById(int id);
}
