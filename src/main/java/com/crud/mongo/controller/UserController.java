package com.crud.mongo.controller;

import java.util.List;
import java.util.Optional;

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
import com.crud.mongo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("add/user")
	public ResponseEntity<User> saveUpdateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUpdateUser(user), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getAll/user")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("get/user/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("delete/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted", HttpStatus.ACCEPTED);
	}

}
