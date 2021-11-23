package com.bookstore.app.dto;

import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.entity.UserEntity;

public class CartDto {
	public UserEntity userId;
	public BookEntity bookId;
	public int quantity;
	
}
