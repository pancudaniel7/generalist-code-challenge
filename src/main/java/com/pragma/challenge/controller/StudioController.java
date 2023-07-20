package com.pragma.challenge.controller;

import org.springframework.web.bind.annotation.*;

import com.pragma.challenge.model.*;
import com.pragma.challenge.service.*;
import com.pragma.challenge.utils.*;

@RestController
public class StudioController
{
  private final StudioService studioService;
  StudioController(StudioService studioService) {
    this.studioService = studioService;
  }
  
  @GetMapping("/studio")
  @ResponseBody
  String getAllStudios() {
    return StringTools.studioListToString(studioService.getAllStudios());
  }
  
  @GetMapping("/studio/{id}")
  @ResponseBody
  String getOneStudio(@PathVariable int id) {
    
    return studioService.getOneStudio(id).toString();
  }
  
  @PostMapping("/studio")
  @ResponseBody
  String newStudio(@RequestBody Studio newStudio) {
    return studioService.newStudio(newStudio).toString();
  }
  
  @PutMapping("/studio/{id}")
  @ResponseBody
  String replaceStudio(@RequestBody Studio newStudio, @PathVariable Integer id) {
    
    return studioService.replaceStudio(newStudio, id).toString();
  }
  
  @DeleteMapping("/studio/{id}")
  @ResponseBody
  void deleteStudio(@PathVariable Integer id) {
    studioService.deleteStudio(id);
  }
}
