package com.bookstore.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UserDto {
	
	private String fullName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	
}