package com.bookstore.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookstore.app.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Book") 
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String author;
	private int price;
	private int markedPrice;
	private double rating;
	private String img;
	private int quantity;
	
	@Column(length = 1000)
	private String description;

	public BookEntity(BookDto bookDto){
		super();
		this.id=id;
		this.name=bookDto.getName();
		this.author=bookDto.getAuthor();
		this.price=bookDto.getPrice();
		this.rating=bookDto.getRating();
		this.img=bookDto.getImg();
		this.description=bookDto.getDescription();
		this.quantity=bookDto.getQuatity();
		this.markedPrice=bookDto.getMarkedPrice();
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
		this.quantity=bookDto.getQuatity();
	}
	
}
