package com.examplevalidation.validationexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplevalidation.validationexample.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int id);

}
