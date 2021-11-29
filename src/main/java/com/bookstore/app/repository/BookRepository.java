package com.bookstore.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.entity.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	
	
	public List<BookEntity> findAllByNameStartsWith(String name);
	
	public BookEntity findByName(String name);


}
