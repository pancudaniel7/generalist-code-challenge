package com.challenge.controller;

import static com.challenge.utils.NumberUtils.generateRating;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.model.Game;
import com.challenge.service.GameService;

/**
 * Class which handles the endpoints for game entity, part of API layer
 */
@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {
	private static Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@PostMapping(value="/create")
	public void createGame(@RequestBody Game game) {
		logger.info("[CREATE] - storing game called " + game.getName());

		game.setRating(generateRating());

		gameService.saveGame(game);
	}

	@GetMapping(value="/view")
	public List<Game> getAllGames() {
		logger.info("[GET] - fetching all games.");
		return gameService.getAllGames();
	}

	@GetMapping(value="/view/{studioId}")
	public List<Game> getAllGames(@PathVariable int studioId) {
		logger.info("[GET] - fetching all games with studio's ID:" + studioId);
		return gameService.getAllGames(studioId);
	}

	@DeleteMapping(value="/delete/{id}")
	public void removeGame(@PathVariable int id) {
		logger.info("[DELETE] - deleting game with ID: " + id);
		gameService.deleteGame(id);
	}
}
