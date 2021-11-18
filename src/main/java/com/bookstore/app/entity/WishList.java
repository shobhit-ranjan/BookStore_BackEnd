package com.bookstore.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishList {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    
	    @OneToOne
	    private UserEntity userEntity;
	    
	    @OneToMany
	    private List<BookEntity> bookList;
}
