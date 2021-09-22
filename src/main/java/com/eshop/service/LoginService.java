package com.eshop.service;

import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingRequest;
import com.eshop.model.UserAddress;
import com.eshop.model.UserDetails;
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

    public CommonResponse authenticateUserViaPost(UserDetails user) {

        return loginRepo.authenticateUser(user);

    }

    public CommonResponse userSignUp(UserDetails user) {
        return loginRepo.userSignUp(user);
    }

    public CommonResponse addAddress(UserAddress address) {
        return loginRepo.addUserAddress(address);
    }

    public CommonResponse setDefaultAddress(UserAddress address) {
        return loginRepo.setAsDefaultAddress(address);
    }
}

