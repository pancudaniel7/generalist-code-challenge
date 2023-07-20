package com.pragma.challenge.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;

@RestController
public class StudioController
{
  private final StudioService studioService;
  StudioController(StudioService studioService) {
    this.studioService = studioService;
  }
  
  @GetMapping("/studio")
  List<Studio> all() {
    return studioService.getAllStudios();
  }
  
  @GetMapping("/studio/{id}")
  Studio getOne(@PathVariable int id) {
    
    return studioService.getOneStudio(id);
  }
  
  @PostMapping("/studio")
  Studio newStudio(@RequestBody Studio newStudio) {
    return studioService.newStudio(newStudio);
  }
  
  @PutMapping("/studio/{id}")
  Studio replaceStudio(@RequestBody Studio newStudio, @PathVariable Integer id) {
    
    return studioService.replaceStudio(newStudio, id);
  }
  
  @DeleteMapping("/studio/{id}")
  void deleteStudio(@PathVariable Integer id) {
    studioService.deleteStudio(id);
  }
}
