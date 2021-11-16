package com.bookstore.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bookstore.app.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String author;
	private int price;
	private double rating;
	private String img;
	private String description;
	@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
	

	public BookEntity(BookDto bookDto){
		super();
		this.id=id;
		this.name=bookDto.getName();
		this.author=bookDto.getAuthor();
		this.price=bookDto.getPrice();
		this.rating=bookDto.getRating();
		this.img=bookDto.getImg();
		this.description=bookDto.getDescription();
	}
	
	
	public BookEntity(int id, BookDto bookDto){
		super();
		this.id=id;
		this.name=bookDto.getName();
		this.author=bookDto.getAuthor();
		this.price=bookDto.getPrice();
		this.rating=bookDto.getRating();
		this.img=bookDto.getImg();
		this.description=bookDto.getDescription();
	}
	
	
	
}
