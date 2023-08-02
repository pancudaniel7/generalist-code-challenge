package com.pragma.challenge.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.repository.*;
import com.pragma.challenge.service.*;
import com.pragma.challenge.utils.*;

@Service
public class GameServiceImpl implements GameService
{
  @Autowired
  GameRepository gameRepository;
  @Autowired
  StudioRepository studioRepository;
  
  @Override
  public List<Game> getAllGames() {
    return gameRepository.findAll();
  }
  
  @Override
  public Optional<Game> getOneGame(int id) {
    return gameRepository.findById(id);
  }
  
  @Override
  public Game newGame(Game newGame) {
    newGame.setRating(RandomTools.getRandomRating(1,5));
    return gameRepository.save(newGame);
  }
  
  @Override
  public Game replaceGame(
      Game newGame,
      Integer id) {
    
    return gameRepository.findById(id)
        .map(game -> {
          game.setName(newGame.getName());
          game.setStudio_key(newGame.getStudio_key());
          game.setRating(RandomTools.getRandomRating(1,5));
          game.setStudio_key(newGame.getStudio_key());
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
  
  @Override
  public List<Game> getGamesByStudio(String name)
  {
    Optional<Studio> studio = studioRepository.findStudioByName(name);
    if (studio.isPresent()) {
      return gameRepository.findAll().stream()
          .filter(game -> studio.get().getId() == game.getStudio_key()).toList();
    } else {
      throw new IllegalStateException("No Studio with name: " + name);
    }
  }
}
