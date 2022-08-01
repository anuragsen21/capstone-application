package com.capstone.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dto.MovieDTO;
import com.capstone.entity.Movie;
import com.capstone.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repo;	
	public void insertMovie(List<MovieDTO> dto) {
		for (int i = 0; i < dto.size(); i++) {
			Movie entity = new Movie();
			entity.setMovieId(dto.get(i).getMovieId());
			entity.setMovieTitle(dto.get(i).getMovieTitle());
			entity.setDateReleased(dto.get(i).getDateReleased());
			entity.setMovieRunningTime(dto.get(i).getMovieRunningTime());
			repo.save(entity);
		}
	}
	
	public void insertOneMovie(MovieDTO dto) {
		Movie entity = new Movie();
		entity.setMovieId(dto.getMovieId());
		entity.setMovieTitle(dto.getMovieTitle());
		entity.setDateReleased(dto.getDateReleased());
		entity.setMovieRunningTime(dto.getMovieRunningTime());
		repo.save(entity);
	}
	
	public void insertMovieAndDirector(Movie movie) {
		repo.save(movie);
	}
	
	public List<Movie> getAllMovies() {
		 List<Movie> list = repo.findAll();
		 return list;
	}
	
	public Movie getMovieByName(String movieName) throws Exception{
		Optional<Movie> opt = repo.findByMovieTitleEquals(movieName);
		Movie m = opt.orElseThrow(() -> new Exception("Invalid Movie title : " + movieName));
		return m;
	}
	
	public List<Movie> getMovieByNamesLike(String name) {
		return repo.findByMovieTitleLike(name);
	}
	
	public List<Movie> getMovieByDirectorName(String dirFirstName, String dirLastName) throws Exception {
		return repo.customGetMovieByDirectorName(dirFirstName, dirLastName);
	}
	
	public void updateMovieReleaseDate(int id, LocalDate newDate) {
		repo.customUpdateMovieReleaseDate(id, newDate);
	}
	
	public void removeMovie(int movieId) {
		repo.deleteById(movieId);
	}
}
