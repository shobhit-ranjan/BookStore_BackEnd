package com.bookstore.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.entity.Cart;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	public Wishlist findByUserAndBook(UserEntity user, BookEntity book);
	public List<Wishlist> findByUser(UserEntity user);
}
