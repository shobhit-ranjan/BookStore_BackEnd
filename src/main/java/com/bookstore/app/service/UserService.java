package com.bookstore.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRegisterRepository;
	
	
	public UserEntity add(UserDto userDto) {
		UserEntity registedUser= userRegisterRepository.findByEmailId(userDto.emailId);
	    UserEntity userEntity = new UserEntity(userDto);
		if(registedUser == null){
			
			userRegisterRepository.save(userEntity);
			return userEntity;			
		}
		return null;
	}
	
	public List<UserEntity> getall(){
		log.info("Printing All data");
		return userRegisterRepository.findAll();
	}

}
