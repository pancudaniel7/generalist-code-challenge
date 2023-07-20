package com.pragma.challenge.model;

import java.util.*;
import java.util.stream.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
            : games.stream().map(Game::getName).collect(Collectors.joining(", ")))
        + " ]";
  }
}
