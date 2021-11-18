package com.bookstore.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int Id;
	    private String name;
	    private String pincode;
	    private String locality;
	    private String address;
	    private String city;
	    private String landmark;
	    private String addressType;
	    
	    @ManyToOne
	    private UserEntity User;
}
