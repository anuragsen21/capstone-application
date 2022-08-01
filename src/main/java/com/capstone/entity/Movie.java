package com.capstone.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.JoinColumn;


@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(length = 11)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	
	@Column(length = 100)
	private String movieTitle;
	
	@Column(columnDefinition="DATE DEFAULT CURRENT_DATE")
	private LocalDate dateReleased;
	
	@Column(columnDefinition="DATETIME DEFAULT CURRENT_DATE")
	private LocalDateTime movieRunningTime;
	
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(
	  name = "movie_director", 
	  joinColumns = @JoinColumn(name = "movie_id"), 
	  inverseJoinColumns = @JoinColumn(name = "director_id"))
	Set<Director> director  = new HashSet<>();

	public Movie() { }
	
	public Movie(Integer id, String name, LocalDate dateReleased, LocalDateTime movieRunningTime) {
		super();
		this.movieId			= id;
		this.movieTitle			= name;
		this.dateReleased		= dateReleased;
		this.movieRunningTime	= movieRunningTime;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public LocalDate getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}

	public LocalDateTime getMovieRunningTime() {
		return movieRunningTime;
	}

	public void setMovieRunningTime(LocalDateTime movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}

	public Set<Director> getDirector() {
		return director;
	}

	public void setDirector(Set<Director> director) {
		this.director = director;
	}
	
}
