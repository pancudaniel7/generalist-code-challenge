package com.pragma.challenge.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.repository.*;
import com.pragma.challenge.service.*;

@Service
public class StudioServiceImpl implements StudioService
{
  @Autowired
  private StudioRepository studioRepository;

  @Override
  public List<Studio> getAllStudios() {
    return studioRepository.findAll();
  }
  
  @Override
  public Optional<Studio> getOneStudio(int id) {
    
    return studioRepository.findById(id);
  }
  
  @Override
  public Studio newStudio(Studio newStudio) {
    return studioRepository.save(newStudio);
  }
  
  @Override
  public Studio replaceStudio(
      Studio newStudio,
      Integer id) {
    
    return studioRepository.findById(id)
        .map(studio -> {
          studio.setName(newStudio.getName());
          studio.setCity(newStudio.getCity());
          return studioRepository.save(studio);
        })
        .orElseGet(() -> {
          newStudio.setId(id);
          return studioRepository.save(newStudio);
        });
  }
  
  @Override
  public void deleteStudio(Integer id) {
    studioRepository.deleteById(id);
  }
}
