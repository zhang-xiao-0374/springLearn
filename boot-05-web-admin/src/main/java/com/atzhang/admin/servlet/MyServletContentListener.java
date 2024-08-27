package com.atzhang.admin.servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@WebListener
public class MyServletContentListener  implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		log.info("MyServletContentListener监听到了项目初始化完成");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("MyServletContentListener监听到了项目销毁完成");
	}

}
