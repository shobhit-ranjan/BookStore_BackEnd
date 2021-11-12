package com.bookstore.app.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookstore.app.dto.UserDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	
	public UserEntity(int id, UserDto userbookdto) {
		super();
		this.id = id;
		this.fullName=userbookdto.getFullName();
		this.emailId=userbookdto.getEmailId();
		this.password=userbookdto.getPassword();
		this.phoneNumber=userbookdto.getPhoneNumber();
		}

	 public UserEntity(UserDto userbookdto) {
		super();
		this.id = id;
		this.fullName=userbookdto.getFullName();
		this.emailId=userbookdto.getEmailId();
		this.password=userbookdto.getPassword();
		this.phoneNumber=userbookdto.getPhoneNumber();
		}
	
	
	

}



