package com.bookstore.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.dto.ResponceDto;
import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins="*")
@RequestMapping("/NewUser")
@Slf4j
@RestController
public class UserRegisterController {
	
	
	@Autowired
	UserService registerservice;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(path="/signup")
	public ResponseEntity<ResponceDto> post(@RequestBody UserDto userregisterdto) {
		ResponceDto userregisterresponcedto = new ResponceDto("Added successfully!", registerservice.add(userregisterdto));
		return new ResponseEntity<ResponceDto>(userregisterresponcedto , HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/")
	public ResponseEntity<ResponceDto> getAllEmployeeData() {
		List<UserEntity> List = registerservice.getall();
		ResponceDto userregisterresponcedto = new ResponceDto("Total List!", List);
		return new ResponseEntity<ResponceDto>(userregisterresponcedto, HttpStatus.OK);
	}

}
