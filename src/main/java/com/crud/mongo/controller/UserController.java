package com.crud.mongo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.mongo.model.User;
import com.crud.mongo.sequence.SequenceGenerator;
import com.crud.mongo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUpdateUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUpdateUser(user), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getUser(@Valid @PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted", HttpStatus.ACCEPTED);
	}

}
