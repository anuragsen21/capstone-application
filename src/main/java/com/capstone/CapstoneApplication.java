package com.capstone;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capstone.entity.Director;
import com.capstone.entity.Movie;
import com.capstone.service.MovieService;
import com.capstone.service.DirectorService;


@SpringBootApplication
public class CapstoneApplication implements CommandLineRunner {

	@Autowired
	private MovieService movieService;
	@Autowired
	private DirectorService directorService;
	
	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		////////Insert Director & Movies
		insertDirectorAndMovie();
		
		////////Display all the movies 
		displayAllMovies();
		
		////////List movies based on the movie title
		////////Display movies based on the title, if not present, then display exception with the message "Invalid Movie title".
		displayMoviesBasedOnTitle();
		
		////////Display movies based on the title like, if not present, then display exception with the message "Invalid Movie title".
		displayMoviesBasedOnTitleLike();
      
		////////List movies based on director name
		////////Display movie based on the director's first and last name, if the director's name is 
		////////not present, then display exception with the message "Invalid Director name".
		displayDirectorDetails();
		
		////////List director's details based on the movie title
		////////Display director's details based on the movie title, if not present, then display exception with message "Invalid Movie title"
		displayDirectorByMovieTitle();
		
		////////Update director details based on director first and last name
		////////Provide the director's first name and last name to update his new address, contact number and 
		////////display appropriate error messages for the invalid details.
		updateDirectorDetails();

		////////- Update new release date based on the movie title
		////////Update the new release date for the existing movie and display appropriate error messages for invalid details.		
		updateMovieDetails();

		////////Remove movie based on movie title
		deleteMovieByName();
  
	}
	
	public void insertDirectorAndMovie() {
		Movie eMovie = new Movie(8, "Bhahubali 2", LocalDate.now(), LocalDateTime.now());
		Director eDirector = new Director(3, "SS", "Rajamouli", "Dir Address Three", 1111111113, "rajamouli@mail.com");
		eMovie.getDirector().add(eDirector);
		eDirector.getMovie().add(eMovie);
		movieService.insertMovieAndDirector(eMovie);
	}
	
	public void displayAllMovies() {
		List<Movie> list = movieService.getAllMovies();
		if(list.size() > 0) {
			System.out.println("Movie Names : ");
			for (Movie movie : list) {
				System.out.println(movie.getMovieTitle());
			}
		}else {
			System.out.println("No Movie Found !!!");
		}
	}
	
	public void displayMoviesBasedOnTitle() throws Exception {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Movie : ");
		String movieName 	= scan.nextLine();
		Movie srchMov		= movieService.getMovieByName(movieName);
		System.out.println(srchMov.getMovieTitle());
		scan.close();
	}
	
	public void displayMoviesBasedOnTitleLike() {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Movie Like : ");
		String inMovieName = scan.nextLine();
		List<Movie> srchMovie = movieService.getMovieByNamesLike("%" + inMovieName + "%");
		if(srchMovie.size() > 0) {
			System.out.println("Movie Names : ");
			for (Movie movie : srchMovie) {
				System.out.println(movie.getMovieTitle());
			}
		}else {
			System.out.println("No Movie Found !!!");
		}
		scan.close();
	}
	
	public void displayDirectorDetails() throws Exception {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Director First Name : ");
		String dirFirstName = scan.nextLine();
		System.out.println("Name of Director Last Name : ");
		String dirLastName = scan.nextLine();
		List<Movie> lstSrchMov = null;
		try {
			lstSrchMov = movieService.getMovieByDirectorName(dirFirstName, dirLastName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lstSrchMov.size() > 0) {
			System.out.println("Movie Names : ");
			for (Movie movie : lstSrchMov) {
				System.out.println(movie.getMovieTitle());
			}
		}else {
			scan.close();
			throw new Exception("Invalid Director Name : " + dirFirstName + " " + dirLastName);
		}
		scan.close();
	}
	
	public void displayDirectorByMovieTitle() throws Exception {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Movie : ");
		String movName 		= scan.nextLine();		
		Director dirDetails = directorService.getDirectorDetailsByMovieByName(movName);
		System.out.println("Director Name : " + dirDetails.getFirstName() + " " + dirDetails.getLastName());
		scan.close();
	}
	
	public void updateDirectorDetails() throws Exception {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Director First Name : ");
		String dirInFirstName = scan.nextLine();
		System.out.println("Name of Director Last Name : ");
		String dirInLastName = scan.nextLine();
		Director dirDet = directorService.getDirectorDetails(dirInFirstName, dirInLastName);
		System.out.println("Director's First Name : " + dirDet.getFirstName());
		System.out.println("New Director;s First Name : ");
		String newFName = scan.nextLine();
		System.out.println("Director's Last Name : " + dirDet.getLastName());
		System.out.println("New Director's Last Name : ");
		String newLName = scan.nextLine();
		System.out.println("Director's Address : " + dirDet.getAddress());
		System.out.println("New Director's Address : ");
		String newAddress = scan.nextLine();
		System.out.println("Director's Email : " + dirDet.getEmail());
		System.out.println("New Director's Email : ");
		String newEmail = scan.nextLine();
		System.out.println("Director's Contact Number : " + dirDet.getContactNumber());
		System.out.println("New Director's Contact Number : ");
		Integer newContact = scan.nextInt();
		directorService.updateDirectorDetails(dirDet.getDirectorId(), newFName, newLName, newAddress, newContact, newEmail);
		System.out.println("Director's Details Updated Successfully !!!");
		scan.close();
	}
	
	public void updateMovieDetails() throws Exception {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Movie : ");
		String inMovName 		= scan.nextLine();
		Movie listSrchMov 		= movieService.getMovieByName(inMovName);
		System.out.println(listSrchMov.getMovieTitle());
		System.out.println("Release date of " + listSrchMov.getMovieTitle() + " : " + listSrchMov.getDateReleased());
		System.out.println("New Release Date (yyyy-mm-dd) : ");
		String newDate 			= scan.nextLine();
        LocalDate releaseDate 	= LocalDate.parse(newDate);
		movieService.updateMovieReleaseDate(listSrchMov.getMovieId(), releaseDate);
		System.out.println("Movie Release Date Updated Successfully !!!");
		scan.close();
	}
	
	public void deleteMovieByName() throws Exception {
		Scanner scan 		= new Scanner(System.in);
		System.out.println("Name of Movie To Delete : ");
		String inMovieNam	= scan.nextLine();
		Movie remMovie		= movieService.getMovieByName(inMovieNam);
		movieService.removeMovie(remMovie.getMovieId());
		System.out.println("Movie Deleted Successfully !!!");
		scan.close();
	}
}
