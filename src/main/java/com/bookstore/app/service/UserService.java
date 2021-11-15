package com.bookstore.app.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
	@Autowired
	private static UserRepository userRegisterRepository;
	
	
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

	
	public static String forgotPassword(String email) {

		Optional<UserEntity> userOptional = Optional
				.ofNullable(userRegisterRepository.findByEmail(email));

		if (!userOptional.isPresent()) {
			return "Invalid email id.";
		}

		UserEntity user = userOptional.get();
		user.setToken(generateToken());
		user.setTokenCreationDate(LocalDateTime.now());

		user = userRegisterRepository.save(user);

		return user.getToken();
	}

	public static String resetPassword(String token, String password) {

		Optional<UserEntity> userOptional = Optional
				.ofNullable(userRegisterRepository.findByToken(token));

		if (!userOptional.isPresent()) {
			return "Invalid token.";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";

		}

		UserEntity user = userOptional.get();

		user.setPassword(password);
		user.setToken(null);
		user.setTokenCreationDate(null);

		userRegisterRepository.save(user);

		return "Your password successfully updated.";
	}

	
	private static String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString())
				.append(UUID.randomUUID().toString()).toString();
	}

	
	private static boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);

		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}

}

	
	

