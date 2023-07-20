package com.pragma.challenge.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;
import com.pragma.challenge.utils.*;

@RestController
public class GameController
{
  private final GameService gameService;
  
  GameController(GameService gameService) {
    this.gameService = gameService;
  }
  
  @GetMapping("/games")
  @ResponseBody
  String getAllGames() {
    return StringTools.gameListToString(gameService.getAllGames());
  }
  
  @GetMapping("/games/{id}")
  @ResponseBody
  String getOneGame(@PathVariable int id) {
    
    return gameService.getOneGame(id).toString();
  }
  
  @GetMapping("/games/studio")
  @ResponseBody
  String getGamesByStudio(@RequestParam Optional<String> name) {
    if (name.isPresent()) {
      return StringTools.gameListToString(gameService.getGamesByStudio(name.get()));
    } else {
      return StringTools.gameListToString(gameService.getAllGames());
    }
  }
  
  @PostMapping("/games")
  @ResponseBody
  String newGame(@RequestBody Game newGame) {
    return gameService.newGame(newGame).toString();
  }
  
  @PutMapping("/games/{id}")
  @ResponseBody
  String replaceGame(@RequestBody Game newGame, @PathVariable Integer id) {
    
    return gameService.replaceGame(newGame, id).toString();
    
  }
  
  @DeleteMapping("/games/{id}")
  @ResponseBody
  void deleteGame(@PathVariable Integer id) {
    gameService.deleteGame(id);
  }
}
