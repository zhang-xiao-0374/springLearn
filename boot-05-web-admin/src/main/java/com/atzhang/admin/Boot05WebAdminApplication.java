package com.atzhang.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages="com.atzhang")
@SpringBootApplication
public class Boot05WebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot05WebAdminApplication.class, args);
	}

}
