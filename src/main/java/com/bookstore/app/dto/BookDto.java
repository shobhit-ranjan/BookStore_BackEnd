package com.bookstore.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
	private String name;
	private String author;
	private int price;
	private double rating;
	private String img;
	private String description;
	private int quatity;
	private int markedPrice;
}
