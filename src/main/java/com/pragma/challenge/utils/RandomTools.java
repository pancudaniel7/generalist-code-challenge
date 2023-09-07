package com.pragma.challenge.utils;

import java.util.*;

public class RandomTools
{
  private static final Random rand = new Random();
  public static double getRandomRating(int min, int max) {
    return Math.round((rand.nextDouble(max-1.0d) + min)*100)/100.0d;
  }
  
  public static int getRandomInt(int min, int max) {
    return rand.nextInt(max) + min;
  }
}
