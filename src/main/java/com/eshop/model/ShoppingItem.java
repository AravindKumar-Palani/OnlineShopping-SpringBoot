package com.eshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="items_table")
@Getter
@Setter
@ToString
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

    //no-arg constructor
    public ShoppingItem() {
    }
}
