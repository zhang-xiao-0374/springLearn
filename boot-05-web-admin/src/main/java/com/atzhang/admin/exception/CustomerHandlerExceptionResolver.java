package com.atzhang.admin.exception;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 自定义的异常解析器
 * @Order(value=Ordered.HIGHEST_PRECEDENCE)
 * @Order解析器的优先级设定，默认的为最低级的，数字越小优先级越高
 * @Component 将解析器追加到容器中
 */
@Order(value=Ordered.HIGHEST_PRECEDENCE)
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			Exception ex) {
		try {
			response.sendError(511, "自定义的异常");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}

}
