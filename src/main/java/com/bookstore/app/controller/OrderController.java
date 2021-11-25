package com.bookstore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.dto.ResponseDto;
import com.bookstore.app.repository.OrderRespository;
import com.bookstore.app.service.OrderService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/order")
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/placeorder/{userId}")
	public ResponseEntity<ResponseDto> addOrder(@PathVariable int userId) {
		ResponseDto responseDto = new ResponseDto("Order:", orderService.add(userId) );
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@RequestMapping("/listoforders/{userId}")
	public ResponseEntity<ResponseDto> orderList(@PathVariable int userId) {
		ResponseDto responseDto = new ResponseDto("OrderList:", orderService.getListOfOrder(userId));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
}
