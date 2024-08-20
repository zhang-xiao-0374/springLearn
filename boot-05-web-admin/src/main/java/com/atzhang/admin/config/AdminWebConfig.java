package com.atzhang.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.atzhang.admin.interceptor.LoginInterceptor;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer{
	
	/**
	 * 追加拦截器，拦截哪些请求，放行哪些请求
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		//　"/**"→动静态所有请求都会被拦截，因此需要放行静态资源
		.addPathPatterns("/**")
		.excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");
	}

}
