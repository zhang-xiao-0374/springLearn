package com.atzhang.admin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 处理整个Web的controller异常
 */
@Slf4j
@ControllerAdvice
public class GlabalExceptionController {
	
	/**
	 * @ExceptionHandler({NullPointerException.class, ArithmeticException.class})
	 * 这种写法是用来声明此方法可以处理哪些异常
	 * @return 视图地址
	 */
	@ExceptionHandler({NullPointerException.class, ArithmeticException.class})
	public String handleMathException (Exception ex) {
		log.error("捕获的异常是: {}", ex);
		return "login";
	}

}
