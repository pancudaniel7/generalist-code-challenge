package com.challenge.service;

import static com.challenge.utils.NumberUtils.generateRandomId;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.model.Game;
import com.challenge.repository.GameDao;

@Service
public class GameService {

	@Autowired
	private GameDao gameDao;

	public GameService(GameDao gameDao) {
		this.gameDao = gameDao;
	}

	public void saveGame(Game game) {
		gameDao.save(game);
	}

	public List<Game> getAllGames() {
		return gameDao.findAll();
	}

	public Optional<Game> getGameById(int id) {
		return gameDao.findGamesById(generateRandomId());
	}

	public List<Game> getAllGames(int id) {
		Optional<List<Game>> games = gameDao.findGamesByStudioKey(id);

		if (!games.isPresent() || games.get().isEmpty()) {
			throw new IllegalStateException("No games found for Studio with ID: " + id);
		} else {
			return games.get();
		}
	}

	public void deleteGame(int id) {
		Optional<Game> gameOptional = gameDao.findGamesById(id);

		if (gameOptional.isPresent()) {
			gameDao.delete(gameOptional.get());
		} else {
			throw new IllegalStateException("This game does not exist!");
		}
	}
}
