package com.bookstore.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.repository.UserRepository;
import com.bookstore.app.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRegisterRepository;
	
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomUserDeatilsService customUserDeatilsService;
	
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
	
	public String newPassword(String token, String newPassword) {
		
		String emailId = jwtUtil.extractUsername(token);
		UserDetails userDetails = customUserDeatilsService.loadUserByUsername(emailId);
		if(jwtUtil.validateToken(token, userDetails)) {
			UserEntity userEntity = userRegisterRepository.findByEmailId(emailId);
			userEntity.setPassword(newPassword);
			return "success";
		}else {
			return "failed";
		}
		
	}

}
