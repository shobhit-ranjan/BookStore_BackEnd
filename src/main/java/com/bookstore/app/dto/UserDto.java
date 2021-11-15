package com.bookstore.app.dto;


import java.time.LocalDateTime;

import lombok.Data;
@Data
public class UserDto {
	
	private String fullName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	private String token;
	private LocalDateTime tokenCreationDate;
	
	public UserDto(String fullName, String emailId, String password,Long phoneNumber, String token,LocalDateTime tokenCreationDate ) {
		super();
		
		this.fullName = fullName;
		this.emailId=  emailId;
		this.password =password;
		this.phoneNumber = phoneNumber;
		this.token=token;
		this.tokenCreationDate=tokenCreationDate;
}
	
	
}