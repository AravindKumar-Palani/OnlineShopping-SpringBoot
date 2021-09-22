package com.eshop.controller;

import com.eshop.model.*;
import com.eshop.service.DataLoaderService;
import com.eshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController extends CommonController{

    @Autowired
    LoginService loginService;

    @Autowired
    DataLoaderService dataService;

    @GetMapping(path = "/hello")
    public String greetingMessage(@RequestParam(required = false, name = "userName") String name) {
        return "Hi! " + (StringUtils.hasText(name) ? StringUtils.capitalize(name) : "User") + " Welcome to online shopping portal! :)";
    }

    @GetMapping(path = "/login")
    public String userAuthentication(@RequestParam(required = false, name = "userName") String name,
                                     @RequestParam(required = false, name = "pswd") String password) {

        return loginService.authenticateUser(name, password);
    }

    @PostMapping(path = "/authenticate")
    public CommonResponse userAuthenticationViaPost(@RequestBody UserDetails userDetail) {
        return loginService.authenticateUserViaPost(userDetail);
    }

    @PostMapping(path = "/getInitialData")
    public CategoryResponse homepageDataProvider() {
        return dataService.getInitialData();
    }

    @PostMapping(path = "/Signup")
    public CommonResponse userSignUp(@RequestBody UserDetails userDetail) {
        return loginService.userSignUp(userDetail);
    }

    @PostMapping(path = "/addAddress")
    public CommonResponse addAddress(@RequestBody UserAddress address) {
        return loginService.addAddress(address);
    }

    @PostMapping(path = "/updateDefaultAddress")
    public CommonResponse setAsDefaultAddress(@RequestBody UserAddress address) {
        return loginService.setDefaultAddress(address);
    }

}
