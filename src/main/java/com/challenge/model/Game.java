package com.challenge.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	private int id;

	private String name;
	private double rating;
	private int studioKey;
	private String content;

	public void setId(int id) {
		this.id = id;
	}

	public Game(int id, String name, double rating, int studioKey, String content) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.studioKey = studioKey;
		this.content = content;
	}

	public Game() {
	}

	@Id
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getStudioKey() {
		return studioKey;
	}

	public void setStudioKey(int studioKey) {
		this.studioKey = studioKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Game game = (Game) o;

		return id == game.id && Double.compare(game.rating, rating) == 0 && studioKey == game.studioKey
				&& Objects.equals(name, game.name) && Objects.equals(content, game.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, rating, studioKey, content);
	}
}
