package com.eshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserAddress {

    @Column
    private String phoneNumber;
    @Column
    private String doorNo;
    @Column
    private String Street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String Country;
    @Column
    private int pinCode;
    @Column
    private boolean isDefault;
    @Transient
    private String loggedInUserName;

}
