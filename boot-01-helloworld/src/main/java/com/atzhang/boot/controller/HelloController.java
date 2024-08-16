package com.atzhang.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atzhang.boot.bean.Car;
import com.atzhang.boot.bean.Person;

//@ResponseBody
//@Controller
@RestController
public class HelloController {
	
	@Autowired
	Car car;
	
	@Autowired
	Person person;
	
	
	@RequestMapping("/hello")
	public String  handl01() {
		return "hello springBoot2" +"こんにちは";
	}
	

	
	@RequestMapping("/car")
	public Car car() {
		return car;
	}
	
	@RequestMapping("/person")
	public Person person() {
		return person;
	}

}
