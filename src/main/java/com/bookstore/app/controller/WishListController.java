package com.bookstore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.dto.ResponseDto;
import com.bookstore.app.repository.WishlistRepository;
import com.bookstore.app.service.UserService;
import com.bookstore.app.service.WishlistService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/wishlist")
@RestController
public class WishListController {
	
	@Autowired
	WishlistService service;
	
	/*
	 * add bookId to userID  
	 */
	@RequestMapping("{userId}/{bookId}")
	public ResponseEntity<ResponseDto> addToWishList(@PathVariable int userId, @PathVariable int bookId) {
		ResponseDto responseDto = new ResponseDto("Book:", service.add(userId, bookId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	/*
	 * Get all list by userId
	 */
	@RequestMapping("/{userId}")
	public ResponseEntity<ResponseDto> wishList(@PathVariable int userId) {
		ResponseDto responseDto = new ResponseDto("WishList:",service.getList(userId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	/*
	 * remove bookId from userId
	 */
	@DeleteMapping("{userId}/{bookId}")
	public ResponseEntity<ResponseDto> removeToCart(@PathVariable int userId, @PathVariable int bookId) {
		ResponseDto responseDto = new ResponseDto("Book:", service.delete(userId, bookId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	

}
