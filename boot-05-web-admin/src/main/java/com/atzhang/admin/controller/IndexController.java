package com.atzhang.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.atzhang.admin.bean.User;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@GetMapping(value={"/","/login"})
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String main(User user, HttpSession session, Model model) {
		if((StringUtils.isNotBlank(user.getUserName())) 
				&& "123456".equals(user.getPassword())) {
			session.setAttribute("loginUser", user);
			// 登陆成功，重定向的方式到main页面
			return "redirect:/main.html";
		} else {
			model.addAttribute("msg", "账户或者密码错误");
			return "login";
		}
		
	}

	@GetMapping("/main.html")
	public String mainPage(HttpSession session, Model model) {
		Object object = session.getAttribute("loginUser");
		if(!ObjectUtils.isEmpty(object)) {
			return "main";
		} else {
			model.addAttribute("msg", "请重新登录");
			return "login";
		}
		
	}
}
