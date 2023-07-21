package com.challenge.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.challenge.Challenge;
import com.challenge.model.Game;
import com.challenge.repository.GameDao;
import com.challenge.service.GameService;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(properties = "spring.main.lazy-initialization=true",
		classes = {GameController.class})
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Challenge.class})
class GameControllerTest {

	@Autowired
	GameService gameService;

	@Autowired
	GameDao gameDao;

	@Autowired
	GameController gameController;

	@BeforeEach
	void setUp() {

		gameDao.deleteAll();
	}

	@Test
	void whenCreateGameThenSuccess() {

		// setup
		Game newGame = new Game(563,"Age Of Empires", 4.9,3, "Very good game");

		// execute
		gameController.createGame(newGame);

		// verify
		assertTrue(gameDao.existsById(563));
	}
}