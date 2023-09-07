package com.pragma.challenge.model;

import java.util.*;
import java.util.stream.*;

import jakarta.persistence.*;

@Entity
@Table(name = "studio")
public class Studio
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  @Column(nullable = false)
  String name;
  @Column(nullable = false)
  String city;
  @OneToMany(cascade = CascadeType.REMOVE)
  @JoinColumn(name="studio_key", referencedColumnName="id")
  List<Game> games;
  
  public int getId()
  {
    return id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getCity()
  {
    return city;
  }
  
  public void setCity(String city)
  {
    this.city = city;
  }
  
  public List<Game> getGames()
  {
    return games;
  }
  
  public void setGames(List<Game> games)
  {
    this.games = games;
  }
  
  @Override
  public String toString() {
    return "#" + id
        + " name="
        + name
        + " | city="
        + city
        + " | games=[ "
        + (games.isEmpty() ?
            "N/A"
            : games.stream().map(game -> game.name).collect(Collectors.joining(", ")))
        + " ]";
  }
}
