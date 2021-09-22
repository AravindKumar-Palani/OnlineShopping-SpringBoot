package com.eshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String orderNumber;

    @Column
    private String userName;
    @Column
    private String timeStamp;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="orderId")
    @Fetch(FetchMode.JOIN)
    private List<ShoppingItem> orderItems;

}
