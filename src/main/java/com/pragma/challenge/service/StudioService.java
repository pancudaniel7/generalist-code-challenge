package com.pragma.challenge.service;

import java.util.*;

import com.pragma.challenge.model.*;

public interface StudioService
{
  List<Studio> getAllStudios();
  
  Studio getOneStudio(int id);
  
  Studio newStudio(Studio newStudio);
  
  Studio replaceStudio(
      Studio newStudio,
      Integer id);
  
  void deleteStudio(Integer id);
}
