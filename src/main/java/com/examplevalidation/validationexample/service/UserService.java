package com.examplevalidation.validationexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplevalidation.validationexample.dto.UserRequest;
import com.examplevalidation.validationexample.entity.User;
import com.examplevalidation.validationexample.exception.UserNotFoundException;
import com.examplevalidation.validationexample.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	private IUserRepository userRepository;
	
	//create
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0,
				userRequest.getUserName(), userRequest.getDateOfBirth(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender());
		
		return userRepository.save(user);
	}
	
	//get
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	//single user
	public User getUser(int id) throws UserNotFoundException {
		User user = userRepository.findByUserId(id);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found");
		}
		
	}
	
	//update user
	public void updateUser(int id, UserRequest newUser) throws UserNotFoundException {
		User newuser = userRepository.findByUserId(id);
		if(newuser != null) {
			newuser.setUserName(newUser.getUserName());
			newuser.setDateOfBirth(newUser.getDateOfBirth());
			newuser.setEmail(newUser.getEmail());
			newuser.setMobile(newUser.getMobile());
			newuser.setGender(newUser.getGender());
			userRepository.save(newuser);
		}else {
			throw new UserNotFoundException("user not found to update");
		}
		
	}
	//delete by id
	public void deleteUser(int id) throws UserNotFoundException {
		User newuser = userRepository.findByUserId(id);
		if(newuser!=null) {
			userRepository.deleteById(id);
		}else {
			throw new UserNotFoundException("user not found to delete");
		}
	}
	

}
