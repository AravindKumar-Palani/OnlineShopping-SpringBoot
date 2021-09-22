package com.eshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart_table")
@IdClass(UserItem.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartItem {
    @Id
    @Column
    private String userName;
    @Id
    @Column
    private String itemId;
    @Column
    private String count;

    public CartItem(String userName, String itemId) {
        super();
        this.userName = userName;
        this.itemId = itemId;
    }

}
