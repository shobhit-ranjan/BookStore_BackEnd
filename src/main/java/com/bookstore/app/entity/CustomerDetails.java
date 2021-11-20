package com.bookstore.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Customer_Details") 
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
	    
	    @ManyToOne(cascade = {CascadeType.ALL})
	    private UserEntity User;
}
