package com.pragma.challenge.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game")
public class Game
{
  @Id
  @GeneratedValue
  int id;
  @Column(nullable = false)
  String name;
  @Column(nullable = false)
  double rating;

  @ManyToOne
  @JoinColumn(name="studio_key", referencedColumnName="id")
  Studio studio;
  @Column
  String content;
}
