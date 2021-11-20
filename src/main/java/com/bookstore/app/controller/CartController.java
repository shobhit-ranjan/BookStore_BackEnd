package com.bookstore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.dto.ResponseDto;
import com.bookstore.app.service.UserService;

@CrossOrigin("*")
@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	UserService userService;

	@RequestMapping("/{bookId}")
	public ResponseEntity<ResponseDto> addToCart(@RequestParam(value="Id") String emailId, @PathVariable int bookId) {
		ResponseDto responseDto = new ResponseDto("Book:", userService.addToCart(emailId, bookId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@RequestMapping("/")
	public ResponseEntity<ResponseDto> cartList(@RequestParam(value = "Id") String emailId) {
		ResponseDto responseDto = new ResponseDto("CartList:", userService.getCartList(emailId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<ResponseDto> removeToCart(@PathVariable int bookId, @RequestParam(value="Id") String emailId) {
		ResponseDto responseDto = new ResponseDto("Book:", userService.removeFromCart(emailId, bookId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
}
