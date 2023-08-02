package com.pragma.challenge.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;

@RestController
public class GameController
{
  @Autowired
  GameService gameService;
  

  @GetMapping("/games")
  @ResponseBody
  List<Game> getGamesByStudio(@RequestParam Optional<String> studioName) {
    if (studioName.isPresent()) {
      return gameService.getGamesByStudio(studioName.get());
    } else {
      return gameService.getAllGames();
    }
  }
  
  @GetMapping("/games/{id}")
  @ResponseBody
  Optional<Game> getOneGame(@PathVariable int id) {
    
    return gameService.getOneGame(id);
  }
  
  @PostMapping("/games")
  @ResponseBody
  Game newGame(@RequestBody Game newGame) {
    return gameService.newGame(newGame);
  }
  
  @PutMapping("/games/{id}")
  @ResponseBody
  Game replaceGame(@RequestBody Game newGame, @PathVariable Integer id) {
    
    return gameService.replaceGame(newGame, id);
    
  }
  
  @DeleteMapping("/games/{id}")
  @ResponseBody
  void deleteGame(@PathVariable Integer id) {
    gameService.deleteGame(id);
  }
}
