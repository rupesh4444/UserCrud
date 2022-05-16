package com.crud.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.mongo.model.User;
import com.crud.mongo.repository.UserRepository;
import com.crud.mongo.sequence.SequenceGenerator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired	
	private SequenceGenerator sequenceGenerator;
	
	public User saveUpdateUser(User user) {
		Long id = sequenceGenerator.getSequence(User.SEQUENCE_NAME);
		
		if(user.getId() != null && id >= user.getId())
			return userRepository.save(user);
		
		user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
