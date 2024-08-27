package com.atzhang.admin.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atzhang.admin.servlet.MyFilter;
import com.atzhang.admin.servlet.MyServlet;
import com.atzhang.admin.servlet.MyServletContentListener;

@Configuration
public class MyRegistConfig {
	
	@Bean
	public ServletRegistrationBean myServlet() {
		MyServlet myServlet = new MyServlet();
		
		return new ServletRegistrationBean(myServlet, "/my");
	}
	
	@Bean
	public FilterRegistrationBean myFilter() {
		MyFilter myFilter = new MyFilter();
		
//		return new FilterRegistrationBean(myFilter, myServlet()); 写法一
		// 写法二
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
		
		return filterRegistrationBean;
	}
	
	@Bean
	public ServletListenerRegistrationBean myListener() {
		
		MyServletContentListener myServletContentListener = new MyServletContentListener();
		
		return new ServletListenerRegistrationBean(myServletContentListener);

	}

}
