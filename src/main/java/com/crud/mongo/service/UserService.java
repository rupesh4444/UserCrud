package com.crud.mongo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.mongo.model.User;
import com.crud.mongo.repository.UserRepository;
import com.crud.mongo.sequence.SequenceGenerator;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired	
	private SequenceGenerator sequenceGenerator;
	
	public User saveUpdateUser(User user) {
		Long id = sequenceGenerator.getSequence(User.SEQUENCE_NAME);
		
		if(user.getId() != null && id >= user.getId()) {
			logger.info("Updating the user: {}", user);
			return userRepository.save(user);
		}			
		
		user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
		logger.info("Creating the new user: {}", user);
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		logger.info("Fetching all the users present in the database");
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id) {
		logger.info("Fetching the user with id: {}", id);
		return userRepository.findById(id);
	}
	
	public void deleteUser(Long id) {
		logger.info("Deleting the user with id: {}", id);
		userRepository.deleteById(id);
	}
}
