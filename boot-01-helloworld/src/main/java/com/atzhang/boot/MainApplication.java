package com.atzhang.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序的入口
 * 这是一个springboot应用
 */
@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		// IOCコンテナーが戻り
		ConfigurableApplicationContext run = SpringApplication. run(MainApplication.class, args);
		String[] beanNames = run.getBeanDefinitionNames();
		for(String bean : beanNames) {
			System.out.println(bean);
		}
		
		
	}
	
}
