package com.eshop.model;

import javax.persistence.*;

@Entity
@Table(name="items_table")
public class ShoppingItem {


    @Id
    @Column
    private String itemId;
    @Column
    private String name;
    @Column
    private String userRating;
    @Column
    private String userRatingCount;
    @Column
    private String description;
    @Column
    private Float actualPrice;
    @Column
    private Float discountedPrice;
    @Column
    private Integer discountedPercentage;
    @Transient
    private String categoryId;
    @Column
    private String imageUrls;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public int getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(Integer discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }



    //no-arg constructor
    public ShoppingItem() {
    }
}
