package com.atzhang.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RequestController {
	
	 @GetMapping("/goto")
	 public String goToPage(HttpServletRequest request) {
		 request.setAttribute("msg", "成功だ");
		 request.setAttribute("code", 11);
		 
		 return "forward:/success";
	 }
	 
	 
	 @GetMapping("/param")
	 public String testParam(Map<String, Object> map,
			 Model model,
			 HttpServletRequest request,
			 HttpServletResponse response) {
		 
		 map.put("hello", "こんにちは");
		 model.addAttribute("hello1", "modelWrld");
		 request.setAttribute("hello2", "servletWorld");
		 Cookie cookie = new Cookie("c1", "v1");

		 response.addCookie(cookie);
		 
		 return "forward:/success";
		 
	 }

	 
	 @ResponseBody
	 @GetMapping("/success")
	 public Map<String, Object> success(@RequestAttribute(value="msg", required=false) String msg,
			 @RequestAttribute(value="code", required=false) Integer cd,
			 HttpServletRequest request){
		 
		Object obj =  request.getAttribute("msg");
		 Map<String, Object> map = new HashMap<>();
		 
		 Object hello =request.getAttribute("hello");
			Object hello1 =request.getAttribute("hello1");
			Object hello2 =request.getAttribute("hello2");
		 
		 map.put("msg", msg);
		 map.put("code", cd);
		 map.put("resKey", obj);
		 
		 map.put("msg", msg);
		 map.put("code", cd);
		 map.put("hello", hello);
		 map.put("hello1", hello1);
		 map.put("hello2", hello2);
		 
		 System.out.println("---------"+hello);

		 return map;
		 
	 }
	 
	
}
