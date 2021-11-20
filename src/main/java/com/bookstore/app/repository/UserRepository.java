package com.bookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByEmailId(String email);
	
	public boolean existsByEmailId(String email);
}
