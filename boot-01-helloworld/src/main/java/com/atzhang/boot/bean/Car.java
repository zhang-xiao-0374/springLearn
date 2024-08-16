package com.atzhang.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 在容器中的组件才会拥有springBoot的强大功能
 */
//@Component
@ConfigurationProperties(prefix="mycar")
@Data
public class Car {

	/**
	 * メーカー
	 */
	private String brand;
	/*public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}*/
	private Integer price;
	
	

}
