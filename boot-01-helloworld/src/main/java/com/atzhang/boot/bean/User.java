package com.atzhang.boot.bean;

public class User {
	
	public User() {
		
	}
	
	public User(String userName, Integer age) {
		this.userName = userName;
		this.age= age;
	}
	
	
	private String userName;
	
	private Integer age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	

}
