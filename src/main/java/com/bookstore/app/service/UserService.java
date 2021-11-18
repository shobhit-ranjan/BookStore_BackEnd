package com.bookstore.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.helper.JwtRequest;
import com.bookstore.app.repository.UserRepository;
import com.bookstore.app.service.*;
import com.bookstore.app.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRegisterRepository;

	@Autowired
	private EmailSenderService service;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDeatilsService customUserDeatilsService;

	public UserEntity add(UserDto userDto) {
		UserEntity registedUser = userRegisterRepository.findByEmailId(userDto.emailId);
		UserEntity userEntity = new UserEntity(userDto);
		if (registedUser == null) {

			userRegisterRepository.save(userEntity);
			return userEntity;
		}
		return null;
	}

	public List<UserEntity> getall() {
		log.info("Printing All data");
		return userRegisterRepository.findAll();
	}

	public String forgetPasswordMailSender(String emailId) {
		if (userRegisterRepository.existsByEmailId(emailId)) {
			UserDetails userDetails = customUserDeatilsService.loadUserByUsername(emailId);
			String token = jwtUtil.generateToken(userDetails);

			System.out.println("trying to send");
			service.sendSimpleEmail(emailId,"URL" +token,
					"Reset Your Password for BootStore");
			return ("Sent");
		}
		return "Not Sent";
	}

}
