package com.atzhang.boot.controller;

import java.time.LocalDate;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atzhang.boot.bean.Person;

@Controller
public class ResponseTestController {
	
	@ResponseBody // 利用返回值处理器中消息转换器进行处理
	@GetMapping("/test/person")
	public Person getPerson() {
		Person person = new Person();
		person.setUserName("tom");
		person.setAge(12);
		person.setBirth(LocalDate.now());
		
		return person;
	}
	
	@ResponseBody
	@GetMapping("/file")
	public FileSystemResource file() {
		
		return null;
	}

}
