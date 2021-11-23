package com.bookstore.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.controller.WishListController;
import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.entity.Cart;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.entity.Wishlist;
import com.bookstore.app.helper.Bookcart;
import com.bookstore.app.repository.BookRepository;
import com.bookstore.app.repository.UserRepository;
import com.bookstore.app.repository.WishlistRepository;

@Service
public class WishlistService {
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	public String add(int userId, int bookId) {
		BookEntity book= bookRepo.getById(bookId);
		UserEntity user = userRepo.getById(userId);
		Wishlist wishlist = wishlistRepository.findByUserAndBook(user, book);
		if(wishlist==null && book !=null && user!=null) {
			wishlist= new Wishlist(user, book);
			wishlistRepository.save(wishlist);
		}
		else {
			return "Invalid... Not Added";
		}
		return "Added";
	}
	
	public List<BookEntity> getList(int userId){
		UserEntity user = userRepo.getById(userId);
		List<Wishlist> wishlist= wishlistRepository.findByUser(user);
		List<BookEntity> booklist= wishlist.stream().map(n-> n.getBook()).toList();
		return booklist;
	}
	
	public String delete(int userId, int bookId) {
		BookEntity book= bookRepo.getById(bookId);
		UserEntity user = userRepo.getById(userId);
		Wishlist wish= wishlistRepository.findByUserAndBook(user, book);
		if(wish!=null && book !=null && user!=null) {
			wishlistRepository.delete(wish);
			return "Updated";
		}
		return "Invalid";
	}
}
