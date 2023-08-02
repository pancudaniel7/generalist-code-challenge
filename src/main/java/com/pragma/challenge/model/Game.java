package com.pragma.challenge.model;

import jakarta.persistence.*;

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

  @Column
  int studio_key;
  @Column
  String content;
  
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
  
  public double getRating()
  {
    return rating;
  }
  
  public void setRating(double rating)
  {
    this.rating = rating;
  }
  
  public int getStudio_key()
  {
    return studio_key;
  }
  
  public void setStudio_key(int studio)
  {
    this.studio_key = studio;
  }
  
  public String getContent()
  {
    return content;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  @Override
  public String toString() {
    return "#" + id
        + " name="
        + name
        + " | studio="
        + studio_key
        + " | content="
        + (content != null ? content : "N/A")
        + " | rating="
        + rating;
  }
}
