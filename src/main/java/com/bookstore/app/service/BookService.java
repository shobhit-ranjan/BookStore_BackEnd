package com.bookstore.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BookEntity getById(int id){
		if(bookRepository.getById(id)!=null) {
			return bookRepository.getById(id);
		}else {
			return null;
			
		}
	}
	
	public List<BookEntity> getAllList(){
		return bookRepository.findAll();
	}
	
	public BookEntity addBook(BookEntity bookEntity) {
		bookRepository.save(bookEntity);
		return bookEntity;
	}

}
