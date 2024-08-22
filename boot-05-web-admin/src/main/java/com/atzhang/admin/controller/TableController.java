package com.atzhang.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atzhang.admin.bean.User;
import com.atzhang.admin.exception.UserTooManyException;

@Controller
public class TableController {
	
	/**
	 * 400: badRequest 没有传递参数或者传递的参数不对
	 * @param a
	 * @return
	 */
	@GetMapping("/basic_table")
	public String basic_table(@RequestParam("a")int a) {
		
		int i = 10/0;
		return "table/basic_table";
	}
	
	
	@GetMapping("/dynamic_table")
	public String dynamic_table(Model model) {
		List<User> users = Arrays.asList(new User("野原", "123456"), 
				new User("鈴木", "123456"),
				new User("谷口", "123456"),
				new User("本田", "123456"),
				new User("山本", "123456"));
		model.addAttribute("users", users);
		
		if(users.size() >3) {
			throw new UserTooManyException();
		}
		return "table/dynamic_table";
	}
	
	@GetMapping("/editable_table")
	public String editable_table() {
		return "table/editable_table";
	}
	
	@GetMapping("/pricing_table")
	public String pricing_table() {
		return "table/pricing_table";
	}
	
	@GetMapping("/responsive_table")
	public String responsive_table() {
		return "table/responsive_table";
	}
}
