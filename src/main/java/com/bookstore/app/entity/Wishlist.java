package com.bookstore.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Wish_List") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int wishId;
	    
	    @JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user")
		private UserEntity user;
		
		@JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="book")
		private BookEntity book; 
		
		public Wishlist(UserEntity user, BookEntity book) {
			this.user=user;
			this.book=book;
		}
}
