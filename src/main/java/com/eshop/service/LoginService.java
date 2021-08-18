package com.eshop.service;

import com.eshop.model.ShoppingRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {

    public String authenticateUser(ShoppingRequest loginRequest) {

        String name = loginRequest.getUserName();
        String password = loginRequest.getPassword();

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

