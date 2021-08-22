package com.eshop.model;

import org.springframework.stereotype.Component;

@Component
public class CategoryResponse extends CommonResponse{

    private ShoppingCategory category;

    public ShoppingCategory getCategory() {
        return category;
    }

    public void setCategory(ShoppingCategory category) {
        this.category = category;
    }
}
