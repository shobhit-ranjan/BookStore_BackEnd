package com.bookstore.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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


@CrossOrigin(origins="*")
@Slf4j
@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(path="/signup")
	public ResponseEntity<ResponseDto> post(@RequestBody UserDto userregisterdto) {
		ResponseDto userRegisterResponceDto = new ResponseDto("Added successfully!", userService.add(userregisterdto));
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto , HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/")
	public ResponseEntity<ResponseDto> getAllEmployeeData() {
		List<UserEntity> List = userService.getall();
		ResponseDto userRegisterResponceDto = new ResponseDto("Total List!", List);
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto, HttpStatus.OK);
	}
	
	@PutMapping("/reset-password")
	public ResponseEntity<ResponseDto> resetpassword(@RequestBody NewPassword newPassword) {
		ResponseDto userRegisterResponceDto = new ResponseDto("Total List!", userService.newPassword(newPassword.getToken(), newPassword.getNewPassword()));
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto, HttpStatus.OK);
	}
	
	

}
