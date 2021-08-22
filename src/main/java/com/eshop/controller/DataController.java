package com.eshop.controller;

import com.eshop.model.*;
import com.eshop.service.CategoryService;
import com.eshop.service.ItemService;
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

import java.util.List;

@RestController
@RequestMapping("/e-shop")
public class DataController {

    @Autowired
    LoginService loginService;

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

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
        return itemService.insertItemIndividually(item);
    }

    @PostMapping(path = "/insertItems")
    public boolean insertItemBulk(@RequestBody List<ShoppingItem> itemList) {
        return itemService.insertItems(itemList);
    }

    @GetMapping(path = "/getItem")
    public ShoppingItem getItemById(@RequestParam(name = "id") String itemId) {
        return itemService.getMySearchItem(itemId);
    }

    @GetMapping(path = "/getAllItems")
    public List<ShoppingItem> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(path = "/removeItem")
    public boolean removeItemById(@RequestParam(name = "id") String itemId) {
        return itemService.removeItemViaId(itemId);
    }

    @PostMapping("/updateItem")
    public boolean updateItem(@RequestBody ShoppingItem item) {
        return itemService.updateItem(item);
    }

    @PostMapping("/insertCategory")
    public CommonResponse updateItem(@RequestBody ShoppingCategory category) {
        return categoryService.insertCategoryDetail(category);
    }

    @GetMapping("/getCategory")
    public CategoryResponse updateItem(@RequestParam(name = "id") String categoryId) {
        return categoryService.getSelectedCategory(categoryId);
    }
}
