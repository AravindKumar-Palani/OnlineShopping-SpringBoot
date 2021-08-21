package com.eshop.app;

import com.eshop.model.ShoppingItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

//@EntityScan(basePackageClasses= ShoppingItem.class)
@SpringBootApplication(scanBasePackages =  "com.eshop", exclude = HibernateJpaAutoConfiguration.class)
public class MyOnlineShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOnlineShoppingApplication.class, args);
	}

}
