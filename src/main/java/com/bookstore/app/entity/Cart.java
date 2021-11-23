package com.bookstore.app.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.bookstore.app.dto.CartDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Cart") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int quantity;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@JsonFormat(pattern="dd MM yyyy")
	private LocalDate updatedDate;
	
	@JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user")
	private UserEntity user;
	
	@JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book")
	private BookEntity book; 
	
	public Cart(UserEntity user, BookEntity book, int quantity) {
		this.book=book;
		this.user=user;
		this.quantity=quantity;
	}
	
}
