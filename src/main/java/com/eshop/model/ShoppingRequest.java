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
public class ShoppingRequest {

    private List<ShoppingCategory> categoryList;
    private List<CarouselLoader> carouselList;
}
