package com.pragma.challenge.utils;

import java.util.*;
import java.util.stream.*;

import com.pragma.challenge.model.*;

public class StringTools
{
  private StringTools() {
  }
  
  public static String gameListToString(List<Game> gameList) {
    return gameList
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining("<br>"));
  }
  
  public static String studioListToString(List<Studio> studioList) {
    return studioList
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining("<br>"));
  }
}
