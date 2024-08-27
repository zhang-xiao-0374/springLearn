package com.atzhang.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.atzhang.admin.interceptor.LoginInterceptor;

/**
 * @EnableWebMvc 可以实现全面接管SpringMVC，
 * 因此SpringBoot对SpringMVC的默认配置，如欢迎页，静态资源行为等，都会失效。
 * 所以我们一般只使用@Configuration + 实现 WebMvcConfigurer接口方式，
 * 实现定制化SpringMvc，但不完全接管，此时定制化行为和SpringBoot配置的默认行为都会共同发挥作用。
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		/**
		 * 访问/aa/**都去/static/下进行匹配
		 */
		registry.addResourceHandler("/aa/**")
					.addResourceLocations("classpath:/static/");
	}
	
	
	/**
	 * 追加拦截器，拦截哪些请求，放行哪些请求
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		//　"/**"→动静态所有请求都会被拦截，因此需要放行静态资源
		.addPathPatterns("/**")
		.excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/aa/**");
	}

}
