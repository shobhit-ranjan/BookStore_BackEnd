package com.bookstore.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.entity.Order;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.repository.OrderRespository;
import com.bookstore.app.repository.UserRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderRespository orderRespository;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CartService cartService;
	
	int totalPrice = 0;
	
	public String add(int userId) {
		UserEntity user = userRepo.getById(userId);
		List<Order> oldOrderList=orderRespository.findAllByUser(user);
		int orderSize=orderRespository.findAllByUser(user).size();
		Order newOrder= new Order();
		if(orderSize>0) {
			newOrder.setOrderId(oldOrderList.get(oldOrderList.size()-1).getOrderId()+1);
		}
		else {
			newOrder.setOrderId(1);
		}
		System.out.println("37");
			newOrder.setBookList(cartService.getListForOrder(userId));
			System.out.println("39");
			newOrder.setUser(user);
			totalPrice=0;
			cartService.getList(userId).stream().forEach(n-> totalPrice+=(n.quantity*n.getBook().getPrice()));
			newOrder.setTotalPrice(totalPrice);
			System.out.println(newOrder);
			cartService.deleteAll(user);
			orderRespository.save(newOrder);
		
			return "Order placed";
	}
	
	public List<Order> getListOfOrder(int userId){
		UserEntity user = userRepo.getById(userId);
		return orderRespository.findAllByUser(user);
	}
}
