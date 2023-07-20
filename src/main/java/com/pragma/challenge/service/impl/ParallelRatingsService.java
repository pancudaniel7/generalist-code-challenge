package com.pragma.challenge.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.annotation.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;
import com.pragma.challenge.utils.*;

import lombok.*;

@Component
@Scope("application")
public class ParallelRatingsService extends TimerTask
{
  @Autowired
  private GameService gameService;
  @Override
  public void run()
  {
      List<Game> games = gameService.getAllGames();
      int chosenIndex = RandomTools.getRandomInt(0, games.size());
      Game chosenGame = games.get(chosenIndex);
      chosenGame.setRating(RandomTools.getRandomRating(1, 5));
      gameService.replaceGame(chosenGame, chosenGame.getId());
  }
}
