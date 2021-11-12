package com.bookstore.app.service;

import java.util.List;

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
		UserEntity registedUser= new UserEntity(userDto);
		List<UserEntity> userList = userRegisterRepository.findAll();
		boolean found=false;
		for(UserEntity e: userList) {
			if(e.getEmailId().equals(registedUser.getEmailId())){
				found=true;
				break;
			}
		}
		
		if(!found){
			userRegisterRepository.save(registedUser);
			return registedUser;			
		}
		return null;
	}
	
	public List<UserEntity> getall(){
		log.info("Printing All data");
		return userRegisterRepository.findAll();
	}

}
