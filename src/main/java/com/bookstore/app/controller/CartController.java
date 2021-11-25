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
import com.bookstore.app.repository.CartRepository;
import com.bookstore.app.service.CartService;
import com.bookstore.app.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@RequestMapping("{userId}/{bookId}/{quantity}")
	public ResponseEntity<ResponseDto> addToCart(@PathVariable int userId, @PathVariable int bookId, @PathVariable int quantity) {
		ResponseDto responseDto = new ResponseDto("Book:", cartService.add(userId, bookId, quantity) );
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@RequestMapping("/{userId}")
	public ResponseEntity<ResponseDto> cartList(@PathVariable int userId) {
		ResponseDto responseDto = new ResponseDto("CartList:", cartService.getList(userId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	
	@DeleteMapping("{userId}/{bookId}/{quantity}")
	public ResponseEntity<ResponseDto> removeToCart(@PathVariable int userId, @PathVariable int bookId, @PathVariable int quantity) {
		ResponseDto responseDto = new ResponseDto("Book:", cartService.delete(userId, bookId, quantity));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
}
