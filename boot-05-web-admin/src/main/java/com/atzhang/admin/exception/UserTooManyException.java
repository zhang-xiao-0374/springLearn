package com.atzhang.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="ユーザーが一倍")
public class UserTooManyException extends RuntimeException{
	
	public UserTooManyException() {
		
	}
	
	public UserTooManyException(String message) {
		super(message);
	}

}
