package com.eshop.service;

import com.eshop.model.ShoppingItem;
import com.eshop.model.ShoppingRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {

    public String authenticateUser(String name,String  password) {


        if(StringUtils.hasText(name) & StringUtils.hasText(password)) {
            if(name.equals("admin") & password.equals("pswd")) {

                return "Login successful!";
            } else {
                return "Invalid credentials! please try again!";
            }
        } else {
            return "Please login!";
        }
    }

    public String authenticateUserViaPost(ShoppingRequest request) {

        String name = request.getUserName();
        String password = request.getPassword();

        if(StringUtils.hasText(name) & StringUtils.hasText(password)) {
            if(name.equals("admin") & password.equals("pswd")) {
                return "Login successful!";
            } else {
                return "Invalid credentials! please try again!";
            }
        } else {
            return "Please login!";
        }
    }
}

