package com.pragma.challenge;

import java.util.*;

import org.assertj.core.api.*;
import org.hamcrest.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.repository.*;

@SpringBootTest
@AutoConfigureMockMvc
class ChallengeApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private GameRepository gameRepository;
	
	@Test
	void addGameWorksThroughAllLayers() throws Exception {
		
		String jsonGame = "{\"name\":\"TestGame\",\"studio\":{\"id\":4},\"content\":\"TestGame content\"}";
		
		mockMvc.perform(
						MockMvcRequestBuilders.post("http://localhost:9090/games")
								.contentType("application/json")
								.content(jsonGame))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		List<Game> allGames = gameRepository.findAll();
		
		Game game = allGames.get(allGames.size()-1);
		Assertions.assertThat(game.getName()).isEqualTo("TestGame");
		
		mockMvc.perform(
						MockMvcRequestBuilders.get("http://localhost:9090/games/"+game.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("TestGame")));
		
		mockMvc.perform(
						MockMvcRequestBuilders.delete("http://localhost:9090/games/"+game.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
}
