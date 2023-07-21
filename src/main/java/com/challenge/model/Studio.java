package com.challenge.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "studio")
public class Studio {
	private int id;


	private String name;
	private String city;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "studio_key", referencedColumnName = "id")
	private List<Game> games;

	public Studio(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Studio() {
	}


	public void setId(int id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Studio studio = (Studio) o;
		return Objects.equals(id, studio.id) && Objects.equals(name, studio.name) && Objects.equals(city, studio.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, city);
	}

	@Override
	public String toString() {
		return "Studio{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
