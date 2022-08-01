package com.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dto.DirectorDTO;
import com.capstone.entity.Director;
import com.capstone.repository.DirectorRepository;

@Service
public class DirectorService {
	@Autowired
	private DirectorRepository repo;	
	public void insertDirector(List<DirectorDTO> dto) {
		for (int i = 0; i < dto.size(); i++) {
			Director entity = new Director();
			entity.setDirectorId(dto.get(i).getDirectorId());
			entity.setFirstName(dto.get(i).getFirstName());
			entity.setLastName(dto.get(i).getLastName());
			entity.setAddress(dto.get(i).getAddress());
			entity.setContactNumber(dto.get(i).getContactNumber());
			entity.setEmail(dto.get(i).getEmail());
			repo.save(entity);
		}
	}
	
	public void insertOneDirector(DirectorDTO dto) {
			Director entity = new Director();
			entity.setDirectorId(dto.getDirectorId());
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setAddress(dto.getAddress());
			entity.setContactNumber(dto.getContactNumber());
			entity.setEmail(dto.getEmail());
			repo.save(entity);
	}
	
	public Director getDirectorDetailsByMovieByName(String movieName) throws Exception {
		Optional<Director> opt = repo.customGetDirectorByMovieName(movieName);
		Director d = opt.orElseThrow(() -> new Exception("Invalid Movie title : " + movieName));
		return d;
	}
	
	public Director getDirectorDetails(String dirFirstName, String dirLastName) throws Exception {
		Optional<Director> opt = repo.findByFirstNameAndLastName(dirFirstName, dirLastName);
		Director d = opt.orElseThrow(() -> new Exception("Invalid Director Name : " + dirFirstName + " " + dirLastName));
		return d;
	}
	
	public void updateDirectorDetails(int id, String newFName, String newLName, String newAddress, int newContact, String newEmail) {
		repo.customUpdateDirectorDetails(id, newFName, newLName, newAddress, newContact, newEmail);
	}
}
