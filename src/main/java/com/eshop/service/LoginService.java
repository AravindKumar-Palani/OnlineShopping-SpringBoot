package com.eshop.service;

import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingRequest;
import com.eshop.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

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

    public CommonResponse authenticateUserViaPost(ShoppingRequest request) {

        return loginRepo.authenticateUser(request);

    }
}

