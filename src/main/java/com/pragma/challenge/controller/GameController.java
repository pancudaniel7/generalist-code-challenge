package com.pragma.challenge.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;

@RestController
public class GameController
{
  private final GameService gameService;
  
  GameController(GameService gameService) {
    this.gameService = gameService;
  }
  
  @GetMapping("/games")
  List<Game> all() {
    return gameService.getAllGames();
  }
  
  @GetMapping("/games/{id}")
  Game getOne(@PathVariable int id) {
    
    return gameService.getOneGame(id);
  }
  
  @PostMapping("/games")
  Game newGame(@RequestBody Game newGame) {
    return gameService.newGame(newGame);
  }
  
  @PutMapping("/games/{id}")
  Game replaceGame(@RequestBody Game newGame, @PathVariable Integer id) {
    
    return gameService.replaceGame(newGame, id);
    
  }
  
  @DeleteMapping("/games/{id}")
  void deleteGame(@PathVariable Integer id) {
    gameService.deleteGame(id);
  }
}
