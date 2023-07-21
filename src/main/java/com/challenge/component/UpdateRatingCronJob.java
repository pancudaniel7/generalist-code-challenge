package com.challenge.component;

import static com.challenge.utils.NumberUtils.generateRandomId;
import static com.challenge.utils.NumberUtils.generateRating;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.challenge.model.Game;
import com.challenge.service.GameService;

@Component
public class UpdateRatingCronJob {

	private static Logger logger = LoggerFactory.getLogger(UpdateRatingCronJob.class);

	@Autowired
	GameService gameService;

	public UpdateRatingCronJob(GameService gameService) {
		this.gameService = gameService;
	}

	@Scheduled(fixedRate = 5000)
	public void runTask() {
		Optional<Game> game = gameService.getGameById(generateRandomId());

		if (game.isPresent()) {
			logger.info("Updating rating for game with id: " + game.get().getId());
			game.get().setRating(generateRating());
			gameService.saveGame(game.get());
		}
	}
}
