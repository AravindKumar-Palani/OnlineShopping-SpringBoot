package com.eshop.controller;

import com.eshop.model.ShoppingItem;
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

import java.util.List;

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
		
		return loginService.authenticateUser(name, password);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/authenticate")
	public String userAuthenticationViaPost(@RequestBody ShoppingRequest request) {
		return loginService.authenticateUserViaPost(request);
	}

	@PostMapping(path = "/insertItem")
	public boolean insertItem(@RequestBody ShoppingItem item) {
		return true;
	}

	@PostMapping(path = "/insertItems")
	public boolean insertItemBulk(@RequestBody List<ShoppingItem> itemList) {
		return true;
	}

	@GetMapping(path = "/getItem")
	public ShoppingItem getItemById(@RequestParam(name="id") String itemId) {
		return null;
	}

	@GetMapping(path = "/getAllItems")
	public List<ShoppingItem> getAllItems() {
		return null;
	}
}
