package com.bookstore.app.entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.bookstore.app.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="User") 
@NoArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	private String role;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@JsonFormat(pattern="dd MM yyyy")
	private LocalDate updatedDate;
	
	private boolean status;
	
	
	public UserEntity(int id, UserDto userbookdto) {
		super();
		this.id = id;
		this.fullName=userbookdto.fullName;
		this.emailId=userbookdto.emailId;
		this.password=userbookdto.password;
		this.phoneNumber=userbookdto.phoneNumber;
		}

	 public UserEntity(UserDto userbookdto) {
		super();
		this.id = id;
		this.fullName=userbookdto.fullName;
		this.emailId=userbookdto.emailId;
		this.password=userbookdto.password;
		this.phoneNumber=userbookdto.phoneNumber;
		}


}



