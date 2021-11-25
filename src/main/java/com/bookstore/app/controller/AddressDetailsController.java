package com.bookstore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.dto.AddressDetailsDto;
import com.bookstore.app.dto.ResponseDto;
import com.bookstore.app.service.AddressDetailsService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/address")
@RestController
public class AddressDetailsController {

	@Autowired
	AddressDetailsService service;
	
	@PostMapping("{userId}")
	public ResponseEntity<ResponseDto> addAddress(@PathVariable int userId, @RequestBody AddressDetailsDto dto) {
		ResponseDto responseDto = new ResponseDto("Book:", service.add(dto, userId) );
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@RequestMapping("/{userId}/{type}")
	public ResponseEntity<ResponseDto> getAddress(@PathVariable int userId, @PathVariable int type) {
		ResponseDto responseDto = new ResponseDto("CartList:", service.get(userId, type));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
}
