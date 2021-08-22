package com.eshop.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_table")
public class ShoppingCategory {

    @Id
    @Column(name="category_id")
    private String categoryId;
    @Column(name="category_name")
    private String name;
    @Column(name="category_image_url")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="categoryId")
    @Fetch(FetchMode.JOIN)
    private List<ShoppingItem> itemList;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ShoppingItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ShoppingItem> itemList) {
        this.itemList = itemList;
    }

    //no-arg constructor
    public ShoppingCategory() {
    }
}
