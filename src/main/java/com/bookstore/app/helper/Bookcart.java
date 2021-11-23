package com.bookstore.app.helper;

import com.bookstore.app.entity.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bookcart {
	public BookEntity book;
	public int quantity;
}
