package com.pragma.challenge.model;

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
}
