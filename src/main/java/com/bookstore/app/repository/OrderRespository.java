package com.bookstore.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.entity.Order;
import com.bookstore.app.entity.UserEntity;

@Repository
public interface OrderRespository extends JpaRepository<Order, Integer>{
	public List<Order> findAllByUser(UserEntity user);
}
