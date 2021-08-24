package com.eshop.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryResponse extends CommonResponse{

    private ShoppingCategory category;

    private List<ShoppingCategory> categoryList;

    public ShoppingCategory getCategory() {
        return category;
    }

    public void setCategory(ShoppingCategory category) {
        this.category = category;
    }

    public List<ShoppingCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<ShoppingCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
