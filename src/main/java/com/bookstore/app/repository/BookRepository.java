package com.bookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bookstore.app.entity.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	
	
	public BookEntity findByNameStartsWith(String name);
	
	public BookEntity findByName(String name);


}
