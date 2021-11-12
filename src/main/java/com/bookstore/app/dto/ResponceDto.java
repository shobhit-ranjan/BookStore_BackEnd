package com.bookstore.app.dto;



import lombok.Data;

public @Data class ResponceDto {
	
	private String message;
	private Object data;
	
	public ResponceDto(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}	

}
