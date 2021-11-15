package com.bookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);

	UserEntity findByToken(String token);
	
}
