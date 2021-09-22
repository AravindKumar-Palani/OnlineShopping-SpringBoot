package com.eshop.controller;

import com.eshop.model.*;
import com.eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController extends CommonController {

    @Autowired
    CartService cartService;

    @PostMapping(path = "addToCart")
    public CommonResponse addToCart(@RequestBody CartItem cartItem) {
        return cartService.addToCart(cartItem);
    }

    @GetMapping(path = "getCartDetails")
    public List<CartItem> getCartDetails(@RequestParam String userName) {
        return cartService.getCartDetails(userName);
    }

    @PostMapping(path = "removeFromCart")
    public CommonResponse removeFromCart(@RequestBody CartItem cartItem) {
        return cartService.removeFromCart(cartItem);
    }

    @PostMapping(path = "placeOrder")
    public CommonResponse placeOrders(@RequestBody List<CartItem> cartItems) {
        return cartService.placeOrders(cartItems);
    }

    @PostMapping(path = "placeOrder")
    public CommonResponse placeOrders(@RequestBody ShoppingItem item) {
        return cartService.placeOrders(item);
    }

    public List<Orders> getOrderDetails(@RequestParam String userName) {
        return cartService.getOrderDetails(userName);
    }
}
