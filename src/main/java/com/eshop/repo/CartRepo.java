package com.eshop.repo;

import com.eshop.model.*;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CartRepo extends CommonRepo {

    Logger logger = LoggerFactory.getLogger(CartRepo.class);

    @Autowired
    ItemRepo itemRepo;


    public CommonResponse insertToCart(CartItem cartItem) {

        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            session.save(cartItem);
            logger.trace("Cart Item insert successful - " + cartItem);
            setSuccess(response);
            setSuccess(response);
        } catch (Exception exception) {
            logger.error("Cart insertion failed due to " + exception.getStackTrace());
            setFailure(response, exception);
        }
        return response;
    }

    public List<CartItem> fetchCartDetails(String userName) {
        Session session = getSession();
        Query query = session.createQuery("from CartItem where userName = :userName");
        query.setParameter("userName", userName);
        List<CartItem> myCart = query.getResultList();
        return myCart;
    }

    public CommonResponse removeCartItem(CartItem cartItem) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            session.delete(cartItem);
            logger.trace("Cart Item removal successful - " + cartItem);
            setSuccess(response);
            setSuccess(response);
        } catch (Exception exception) {
            logger.error("Cart removal failed due to " + exception.getStackTrace());
            setFailure(response, exception);
        }
        return response;

    }


    public CommonResponse placeOrders(List<CartItem> cartItems) {
        CommonResponse response = new CommonResponse();
        if (cartItems.size() > 0) {
            String userName = cartItems.get(0).getUserName();
            try {
                Session session = getSession();
                Orders order = new Orders();
                order.setOrderItems(cartItems.stream().map(cartItem ->
                        itemRepo.getMatchingItem(cartItem.getItemId())
                ).collect(Collectors.toList()));
                order.setTimeStamp(commonUtil.getCurrentTime());
                order.setUserName(userName);
                logger.trace("Order placed using cart items " + cartItems);
                setSuccess(response);
            } catch (Exception exception) {
                logger.error("Order placement failed due to " + exception.getStackTrace());
                setFailure(response, exception);
            }
        }
        return response;
    }


    public CommonResponse placeOrders(ShoppingItem item) {

        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            Orders order = new Orders();
            List<ShoppingItem> itemList = new ArrayList<>();
            itemList.add(item);
            order.setOrderItems(itemList);
            order.setTimeStamp(commonUtil.getCurrentTime());
            order.setUserName(item.getUserName());
            logger.trace("Order placed using items " + item);
            setSuccess(response);
        } catch (Exception exception) {
            logger.error("Order placement failed due to " + exception.getStackTrace());
            setFailure(response, exception);
        }
        return response;
    }

    public List<Orders> getOrderDetails(String userName) {
        Session session = getSession();
        Query query = session.createQuery("from Orders where userName = :userName");
        query.setParameter("userName", userName);
        List<Orders> orders = query.getResultList();
        return orders;
    }
}
