package com.bookstore.app.dto;


import lombok.Data;
@Data
public class UserDto {
	
	private String fullName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	
	
	public UserDto(String fullName, String emailId, String password,Long phoneNumber) {
		super();
		
		this.fullName = fullName;
		this.emailId=  emailId;
		this.password =password;
		this.phoneNumber = phoneNumber;
		
}
	
	
}