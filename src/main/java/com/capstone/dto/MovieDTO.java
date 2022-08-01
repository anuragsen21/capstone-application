package com.capstone.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieDTO {
	private Integer movieId;
	private String movieTitle;
	private LocalDate dateReleased;
	private LocalDateTime movieRunningTime;

	public MovieDTO(int id, String name, LocalDate dateReleased, LocalDateTime movieRunningTime) {
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

}
