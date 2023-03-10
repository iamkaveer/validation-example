package com.examplevalidation.validationexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examplevalidation.validationexample.dto.UserRequest;
import com.examplevalidation.validationexample.entity.User;
import com.examplevalidation.validationexample.exception.UserNotFoundException;
import com.examplevalidation.validationexample.service.UserService;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/validation")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/save-user")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
	}
	
	//get all
	@GetMapping("/get-all")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	//get by id
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<User> getById(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	//update
	@PutMapping("/update-user/{id}")
	public void updateUser(@PathVariable int id, @RequestBody UserRequest newUser) throws UserNotFoundException{
		userService.updateUser(id, newUser);
	}
	
	//delete
	@DeleteMapping("delete-user/{id}")
	public void deleteStudent(@PathVariable int id) throws UserNotFoundException {
		userService.deleteUser(id);
	}
}
