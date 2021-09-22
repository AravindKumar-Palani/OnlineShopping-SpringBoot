package com.eshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class CommonResponse {

    private String statusCode;
    private String statusMessage;

    private UserAddress defaultAddress;
    private String userName;
    private List<CartItem> cartItems;
}
