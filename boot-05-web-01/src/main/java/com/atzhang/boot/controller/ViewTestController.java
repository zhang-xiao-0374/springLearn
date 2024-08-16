package com.atzhang.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

	@GetMapping("/zhang")
	public String testThymeleaf(Model model) {
		
		model.addAttribute("msg", "zhang,こんにちは");
		model.addAttribute("link", "http://www.baidu.com");
		return "success";
	}
}
