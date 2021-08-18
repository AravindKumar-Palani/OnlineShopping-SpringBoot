package com.eshop.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

	@GetMapping(path = "/hello")
	public String greetingMessage(@RequestParam(required = false, name= "userName") String name) {
		return "Hi! "+ (StringUtils.hasText(name) ? StringUtils.capitalize(name) : "User");
	}
	
	
	
}
