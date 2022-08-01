package com.capstone.dto;

public class DirectorDTO {
	private Integer directorId;
	private String firstName;
	private String lastName;
	private String address;
	private Integer contactNumber;
	private String email;
	
	public Integer getDirectorId() {
		return directorId;
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

	public DirectorDTO(int id, String firstName, String lastName, String address, 
			Integer contactNumber, String email) {		
		super();
		this.directorId			= id;
		this.firstName 			= firstName;
		this.lastName			= lastName;
		this.address			= address;
		this.contactNumber		= contactNumber;
		this.email				= email;
	}
}