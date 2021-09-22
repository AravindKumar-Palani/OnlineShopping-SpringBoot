package com.eshop.service;

import com.eshop.model.CartItem;
import com.eshop.model.CommonResponse;
import com.eshop.model.Orders;
import com.eshop.model.ShoppingItem;
import com.eshop.repo.CartRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CartService {


    @Autowired
    CartRepo cartRepo;

    public CommonResponse addToCart(CartItem cartItem) {
        return cartRepo.insertToCart(cartItem);
    }

    public List<CartItem> getCartDetails(String userName) {
        return cartRepo.fetchCartDetails(userName);
    }

    public CommonResponse removeFromCart(CartItem cartItem) {
        return cartRepo.removeCartItem(cartItem);
    }

    public CommonResponse placeOrders(List<CartItem> cartItems) {return cartRepo.placeOrders(cartItems);}

    public CommonResponse placeOrders(ShoppingItem item) { return cartRepo.placeOrders(item); }

    public List<Orders> getOrderDetails(String userName) { return cartRepo.getOrderDetails(userName);}
}
