package com.bookstore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.app.dto.ResponseDto;
import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.helper.JwtRequest;
import com.bookstore.app.helper.NewPassword;
import com.bookstore.app.service.UserService;
import com.bookstore.app.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins="http://localhost:4200")
@Slf4j
@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
		
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(path="/signup")
	public ResponseEntity<ResponseDto> post(@Valid @RequestBody UserDto userregisterdto) {
		ResponseDto userRegisterResponceDto = new ResponseDto("Added successfully!", userService.add(userregisterdto));
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto , HttpStatus.OK);
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<ResponseDto> getAllEmployeeData() {
		List<UserEntity> List = userService.getall();
		ResponseDto userRegisterResponceDto = new ResponseDto("All the Users!", List);
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto, HttpStatus.OK);
	}
	
	@PutMapping("/reset-password")
	public ResponseEntity<ResponseDto> resetpassword(@RequestBody NewPassword newPassword) {
		ResponseDto userRegisterResponceDto = new ResponseDto("NewPassWord:", userService.newPassword(newPassword.getToken(), newPassword.getNewPassword()));
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{token}")
	public ResponseEntity<ResponseDto> getUser(@PathVariable String token ) {
		ResponseDto userRegisterResponceDto = new ResponseDto("All the Users!", userService.getUserbyToken(token));
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto, HttpStatus.OK);
	}
	
	

}
