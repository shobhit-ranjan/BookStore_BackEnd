package com.bookstore.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bookstore.app.dto.UserDto;
import com.bookstore.app.entity.BookEntity;
import com.bookstore.app.entity.Cart;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.helper.JwtRequest;
import com.bookstore.app.repository.BookRepository;
import com.bookstore.app.repository.UserRepository;
import com.bookstore.app.service.*;
import com.bookstore.app.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRegisterRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EmailSenderService service;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDeatilsService customUserDeatilsService;

	public UserEntity add(UserDto userDto) {
		UserEntity registedUser = userRegisterRepository.findByEmailId(userDto.emailId);
		UserEntity userEntity = new UserEntity(userDto);
		if (registedUser == null) {

			userRegisterRepository.save(userEntity);
			return userEntity;
		}
		return null;
	}

	public List<UserEntity> getall() {
		log.info("Printing All data");
		return userRegisterRepository.findAll();
	}

	public String newPassword(String token, String newPassword) {

		String emailId = jwtUtil.extractUsername(token);
		UserDetails userDetails = customUserDeatilsService.loadUserByUsername(emailId);
		if (jwtUtil.validateToken(token, userDetails)) {
			UserEntity userEntity = userRegisterRepository.findByEmailId(emailId);
			userEntity.setPassword(newPassword);
			userRegisterRepository.save(userEntity);
			return "success";
		} else {
			return "failed";
		}

	}

	public String forgetPasswordMailSender(String emailId) {
		if (userRegisterRepository.existsByEmailId(emailId)) {
			UserDetails userDetails = customUserDeatilsService.loadUserByUsername(emailId);
			String token = jwtUtil.generateToken(userDetails);

			System.out.println("trying to send");
			service.sendSimpleEmail(emailId, "URL" + token, "Reset Your Password for BootStore");
			return ("Sent");
		}
		return "Not Sent";
	}

	public String addToCart(String emailId, int bookId) {
		UserEntity userEntity = userRegisterRepository.findByEmailId(emailId);
		BookEntity bookEntity = bookRepository.getById(bookId);
		if (userEntity != null && bookEntity != null) {
			Cart cart = new Cart();
			if (userEntity.getCartlist() != null) {
				List<BookEntity> bookList = userEntity.getCartlist().getBookList();
				userRegisterRepository.delete(userEntity);
//				System.out.println(bookList);
				bookList.add(bookEntity);
//				System.out.println(bookList);
				cart.setBookList(null);
//				System.out.println(bookList);
				cart.setBookList(bookList);
			}
			else {
				List<BookEntity> bookList = new ArrayList<>();
				bookList.add(bookEntity);
				cart.setBookList(bookList);
			}
			
			
			userEntity.setCartlist(null);
			userEntity.setCartlist(cart);
			
			userRegisterRepository.save(userEntity);
			return "Added";
		}

		return "Not Added";
	}

	public String removeFromCart(String emailId, int bookId) {
		UserEntity userEntity = userRegisterRepository.findByEmailId(emailId);
		BookEntity bookEntity = userEntity.getCartlist().getBookList().stream().filter((n) -> (n.getId() == bookId))
				.findFirst().orElse(null);
		if (userEntity != null && bookEntity != null) {
			userEntity.getCartlist().getBookList().remove(bookEntity);
			userRegisterRepository.save(userEntity);
			return "Removed";
		}

		return "Not Removed";
	}

	public List<BookEntity> getCartList(String emailId) {
		UserEntity userEntity = userRegisterRepository.findByEmailId(emailId);
		if (userEntity != null) {
			return userEntity.getCartlist().getBookList();
		}
		return null;
	}
	
	public UserEntity getUserbyToken(String Token) {
		UserEntity entity = userRegisterRepository.findByEmailId(jwtUtil.extractUsername(Token));
		return entity;
	}

}
