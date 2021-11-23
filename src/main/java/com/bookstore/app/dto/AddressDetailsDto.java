package com.bookstore.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDetailsDto {
		private String name;
	    private String pincode;
	    private String locality;
	    private String address;
	    private String city;
	    private String landmark;
	    private int type;
}
