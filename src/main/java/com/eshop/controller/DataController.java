package com.eshop.controller;

import com.eshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eshop.model.ShoppingRequest;

@RestController
@RequestMapping("/e-shop")
public class DataController {

	@Autowired
	LoginService loginService;

	@GetMapping(path = "/hello")
	public String greetingMessage(@RequestParam(required = false, name = "userName") String name) {
		return "Hi! " + (StringUtils.hasText(name) ? StringUtils.capitalize(name) : "User");
	}

	@GetMapping(path = "/login")
	public String userAuthentication(@RequestParam(required = false, name = "userName") String name,
			@RequestParam(required = false, name = "pswd") String password) {
		
		if(StringUtils.hasText(name) & StringUtils.hasText(password)) {
			if(name.equals("admin") & password.equals("pswd")) {
				return "Login successful!";
			} else {
				return "Invalid credentials! please re-try!";
			}
		} else {
			return "Please login!";
		}
	}

	@CrossOrigin(origins = "*")
	@PostMapping(path="userLogin")
	public String userAuthenticationViaPost(@RequestBody ShoppingRequest request) {
		return loginService.authenticateUser(request);
	}

}
