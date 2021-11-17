package com.bookstore.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreBackEndApplication.class, args);
		System.out.println("BookStore BackEnd Started");
	}

}
