package com.bookstore.app.dto;

import java.util.List;

import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
	public int orderId;
	public UserEntity user;
	public List<BookEntity> bookList;
}
