package com.atzhang.boot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atzhang.boot.bean.Car;
import com.atzhang.boot.bean.User;

/**
 * @Configuration告知springboot这个是一个配置类
 * 等同于配置文件
 */
@Configuration
@EnableConfigurationProperties(Car.class)
public class MyConfig {
	
	/**
	 * @Bean想容器添加组件，以方法名为组件ID
	 * @return
	 */
	@Bean
	public User user01(){
		return new User("zhangsan", 18);
	}

}
