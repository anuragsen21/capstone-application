package com.capstone.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	public Optional<Movie> findByMovieTitle(String name);
	public Optional<Movie> findByMovieTitleIs(String name);
	public Optional<Movie> findByMovieTitleEquals(String name);
	public List<Movie> findByMovieTitleLike(String likePattern);
	
	@Query(value = "SELECT m.* FROM movie m \r\n"
			+ "LEFT JOIN movie_director mv ON mv.movie_id = m.movie_id\r\n"
			+ "LEFT JOIN director d ON d.director_id = mv.director_id\r\n"
			+ "WHERE d.first_name = :first_name AND d.last_name = :last_name", nativeQuery = true)
	@Transactional
	public List<Movie> customGetMovieByDirectorName(@Param("first_name") String dirFirstName, @Param("last_name") String dirLastName);
	
	@Query(value = "UPDATE `movie` SET \r\n"
			+ "`date_released`	= :date_released\r\n"
			+ "WHERE movie_id	= :movie_id", nativeQuery = true)
	@Modifying
	@Transactional
	public int customUpdateMovieReleaseDate(@Param("movie_id") int id, @Param("date_released") LocalDate newDate);

}
