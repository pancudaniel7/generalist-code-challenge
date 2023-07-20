package com.pragma.challenge.service;

import java.util.*;

import com.pragma.challenge.model.*;

public interface GameService
{
  List<Game> getAllGames();
  
  Game getOneGame(int id);
  
  Game newGame(Game newGame);
  
  Game replaceGame(
      Game newGame,
      Integer id);
  
  void deleteGame(Integer id);
}
