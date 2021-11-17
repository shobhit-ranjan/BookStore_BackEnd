package com.bookstore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.app.dto.ResponseDto;
import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.helper.JwtRequest;
import com.bookstore.app.service.UserService;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins="*")
@Slf4j
@RestController

public class UserRegisterController {
	
	
	@Autowired
	UserService userService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(path="/signup")
	public ResponseEntity<ResponseDto> post(@RequestBody  @Valid UserDto userregisterdto) {
		ResponseDto userRegisterResponceDto = new ResponseDto("Added successfully!", userService.add(userregisterdto));
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto , HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/")
	public ResponseEntity<ResponseDto> getAllEmployeeData() {
		List<UserEntity> List = userService.getall();
		ResponseDto userRegisterResponceDto = new ResponseDto("All the Users!", List);
		return new ResponseEntity<ResponseDto>(userRegisterResponceDto, HttpStatus.OK);
	}
	

}
