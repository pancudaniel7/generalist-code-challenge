package com.pragma.challenge.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;

@RestController
public class StudioController
{
  @Autowired
  StudioService studioService;

  @GetMapping("/studios")
  @ResponseBody
  List<Studio> getAllStudios() {
    return studioService.getAllStudios();
  }
  
  @GetMapping("/studios/{id}")
  @ResponseBody
  Optional<Studio> getOneStudio(@PathVariable int id) {
    return studioService.getOneStudio(id);
  }
  
  @PostMapping("/studios")
  @ResponseBody
  Studio newStudio(@RequestBody Studio newStudio) {
    return studioService.newStudio(newStudio);
  }
  
  @PutMapping("/studios/{id}")
  @ResponseBody
  Studio replaceStudio(@RequestBody Studio newStudio, @PathVariable Integer id) {
    
    return studioService.replaceStudio(newStudio, id);
  }
  
  @DeleteMapping("/studios/{id}")
  @ResponseBody
  void deleteStudio(@PathVariable Integer id) {
    studioService.deleteStudio(id);
  }
}
