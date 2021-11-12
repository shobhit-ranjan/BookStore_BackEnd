package com.bookstore.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository useregisterrepository;
	
	
	public UserEntity add(UserDto userredisterdto) {
		UserEntity registeduser= new UserEntity(userredisterdto);
		useregisterrepository.save(registeduser);
		return  registeduser;
	}
	
	public List<UserEntity> getall(){
		log.info("Printing All data");
		return useregisterrepository.findAll();
	}

}
