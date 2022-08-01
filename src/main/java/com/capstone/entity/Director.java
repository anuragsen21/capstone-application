package com.capstone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "director")
public class Director {
	@Id
	@Column(length = 11)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer directorId;
	
	@Column(length = 100)
	private String firstName;
	
	@Column(length = 50)
	private String lastName;
	
	@Column(length = 150)
	private String address;
	
	@Column(length = 10)
	private Integer contactNumber;
	
	@Column(length = 100)
	private String email;

	public Integer getDirectorId() {
		return directorId;
	}
	
	@ManyToMany(mappedBy = "director")
	Set<Movie> movie  = new HashSet<>();
	

	public Director() { }
	
	public Director(Integer id, String firstName, String lastName, String address, 
			Integer contactNumber, String email) {		
		super();
		this.directorId			= id;
		this.firstName 			= firstName;
		this.lastName			= lastName;
		this.address			= address;
		this.contactNumber		= contactNumber;
		this.email				= email;
	}
	
	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}
	
}
