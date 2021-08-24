package com.eshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
@ToString
public class ShoppingRequest {

    private String userName;
    private String password;

}
