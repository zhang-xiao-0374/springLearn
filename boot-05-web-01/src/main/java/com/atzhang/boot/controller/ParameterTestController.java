package com.atzhang.boot.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atzhang.boot.bean.Person;

@RestController
public class ParameterTestController {
	
	@GetMapping("/car/{id}/owner/{username}")
	public Map<String, Object> getCar(@PathVariable("id") Integer id, 
			@PathVariable("username") String username,
			@PathVariable Map<String, String> pv,
			@RequestHeader("User-Agent") String userAgent,
			@RequestHeader Map<String, String> header,
			@RequestParam("age") Integer age,
			@RequestParam("bith") LocalDate bith,
			@RequestParam("sex") String sex,
			@RequestParam Map<String, String> params
//			@CookieValue("_ga") String _ga,
															){
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("id", id);
		 map.put("username", username);
		 map.put("pv", pv);
		 map.put("userAgent", userAgent);
		 map.put("headers", header);
		 map.put("age", age);
		 map.put("bith", bith);
		 map.put("sex", sex);
		 map.put("params", params);
//		 map.put("_ga",_ga);
//	     System.out.println(cookie.getName()+"===>"+cookie.getValue());
		 return map;
	}
	
	@PostMapping("/save")
	public Map<String, Object> getPost(@RequestBody String content){
		
		 Map<String, Object> map = new HashMap<>();
		 map.put("body", content);
		 return map;
	}
	
	@GetMapping("/cars/{path}")
	public Map<String, Object> carsSell(@MatrixVariable("low")Integer low,
			@MatrixVariable("brand") List<String> brand,
			@PathVariable("path") String path) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("low", low);
		map.put("brand", brand);
		map.put("path", path);
		return map;
	}
	
	
	 @GetMapping("/boss/{bossId}/{empId}")
	    public Map<String, Object> boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
	                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
	        Map<String,Object> map = new HashMap<>();

	        map.put("bossAge",bossAge);
	        map.put("empAge",empAge);
	        return map;

	    }
	 
	 
	 @PostMapping("/saveuser")
	 public Person saveUser(Person person) {
		 
		 return person;
	 }
	 
	
	
}
