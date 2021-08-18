package com.eshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =  "com.eshop")
public class MyOnlineShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOnlineShoppingApplication.class, args);
	}

}
