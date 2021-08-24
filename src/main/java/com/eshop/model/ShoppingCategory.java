package com.eshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_table")
@Getter
@Setter
@ToString
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

    //no-arg constructor
    public ShoppingCategory() {
    }
}
