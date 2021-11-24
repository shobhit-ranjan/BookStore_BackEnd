package com.bookstore.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.entity.Cart;
import com.bookstore.app.entity.UserEntity;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	public Cart findByUserAndBook(UserEntity user, BookEntity book);
	public List<Cart> findByUser(UserEntity user);
	public void deleteAllByUser(UserEntity user);
}
