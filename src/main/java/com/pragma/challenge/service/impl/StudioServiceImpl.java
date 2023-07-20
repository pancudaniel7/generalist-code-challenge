package com.pragma.challenge.service.impl;

import java.util.*;

import org.springframework.stereotype.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.repository.*;
import com.pragma.challenge.service.*;

import lombok.*;

@Service
@AllArgsConstructor
public class StudioServiceImpl implements StudioService
{
  private final StudioRepository studioRepository;

  @Override
  public List<Studio> getAllStudios() {
    return studioRepository.findAll();
  }
  
  @Override
  public Studio getOneStudio(int id) {
    
    return studioRepository.findById(id)
        .orElseThrow(() -> new StudioNotFoundException(id));
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
