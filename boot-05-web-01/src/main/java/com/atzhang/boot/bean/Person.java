package com.atzhang.boot.bean;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Person {
	
	private String userName;
	private Integer age;
	private LocalDate birth;
	private Pet pet;

}
