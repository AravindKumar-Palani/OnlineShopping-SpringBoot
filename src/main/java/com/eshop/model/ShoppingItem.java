package com.eshop.model;

import org.springframework.stereotype.Component;

@Component
public class ShoppingItem {

    private String itemId;
    private String name;
    private String userRating;
    private String userRatingCount;
    private String description;
    private Float actualPrice;
    private Float discountedPrice;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getUserRatingCount() {
        return userRatingCount;
    }

    public void setUserRatingCount(String userRatingCount) {
        this.userRatingCount = userRatingCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
