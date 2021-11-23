package com.bookstore.app.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Address_Details") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetails {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int aId;
	    private String name;
	    private String pincode;
	    private String locality;
	    private String address;
	    private String city;
	    private String landmark;
	    private int type;
	    
	    @JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user")
	    private UserEntity user;

		public AddressDetails(String name, String pincode, String locality, String address, String city,
				String landmark, int type, UserEntity user) {
			super();
			this.name = name;
			this.pincode = pincode;
			this.locality = locality;
			this.address = address;
			this.city = city;
			this.landmark = landmark;
			this.type = type;
			this.user = user;
		}
}
