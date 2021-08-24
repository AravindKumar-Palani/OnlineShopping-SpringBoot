package com.eshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages =  "com.eshop", exclude = HibernateJpaAutoConfiguration.class)
public class MyOnlineShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOnlineShoppingApplication.class, args);
	}

}
