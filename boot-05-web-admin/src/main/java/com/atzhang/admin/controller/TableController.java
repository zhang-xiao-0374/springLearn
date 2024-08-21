package com.atzhang.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atzhang.admin.bean.User;

@Controller
public class TableController {
	
	@GetMapping("/basic_table")
	public String basic_table() {
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
