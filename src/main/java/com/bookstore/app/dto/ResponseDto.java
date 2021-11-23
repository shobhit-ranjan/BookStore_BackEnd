package com.bookstore.app.dto;

import lombok.Data;

public @Data class ResponseDto {
	
	private String message;
	private Object data;
	
	public ResponseDto(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}	

}
