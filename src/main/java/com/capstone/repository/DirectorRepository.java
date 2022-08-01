package com.capstone.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Director;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{
	@Query(value = "SELECT d.* FROM director d \r\n"
			+ "LEFT JOIN movie_director mv ON mv.director_id = d.director_id\r\n"
			+ "LEFT JOIN movie m ON m.movie_id = mv.movie_id\r\n"
			+ "WHERE m.movie_title = :movie_title", nativeQuery = true)
	@Transactional
	public Optional<Director> customGetDirectorByMovieName(@Param("movie_title") String movieName);
	
	public Optional<Director> findByFirstNameAndLastName(String dirFirstName, String dirLastName);
	
	@Query(value = "UPDATE `director` SET \r\n"
			+ "`address` 			= :newAddress,\r\n"
			+ "`contact_number`		= :newContact,\r\n"
			+ "`email`				= :newEmail,\r\n"
			+ "`first_name`			= :newFName,\r\n"
			+ "`last_name`			= :newLName \r\n"
			+ "WHERE director_id	= :director_id", nativeQuery = true)
	@Modifying
	@Transactional
	public int customUpdateDirectorDetails(@Param("director_id") int id, @Param("newFName") String newFName, @Param("newLName") String newLName, 
			@Param("newAddress") String newAddress, @Param("newContact") int newContact, @Param("newEmail") String newEmail);
}
