package com.pragma.challenge.service.impl;

import java.util.*;

import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.repository.*;
import com.pragma.challenge.service.*;

import lombok.*;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService
{
  private final GameRepository gameRepository;
  private final Random rand = new Random();
  
  @Override
  public List<Game> getAllGames() {
    return gameRepository.findAll();
  }
  
  @Override
  public Game getOneGame(int id) {
    
    return gameRepository.findById(id)
        .orElseThrow(() -> new GameNotFoundException(id));
  }
  
  @Override
  public Game newGame(Game newGame) {
    newGame.setRating(getRandomRating());
    return gameRepository.save(newGame);
  }
  
  @Override
  public Game replaceGame(
      Game newGame,
      Integer id) {
    
    return gameRepository.findById(id)
        .map(game -> {
          game.setName(newGame.getName());
          game.setStudio(newGame.getStudio());
          game.setRating(getRandomRating());
          game.setStudio(newGame.getStudio());
          return gameRepository.save(game);
        })
        .orElseGet(() -> {
          newGame.setId(id);
          return gameRepository.save(newGame);
        });
  }
  
  @Override
  public void deleteGame(Integer id) {
    gameRepository.deleteById(id);
  }
  
  private double getRandomRating(){
    int min = 1;
    int max = 4;
    return Math.round((rand.nextDouble(max) + min)*100)/100.0d;
  }
}
