package com.eshop.model;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class UserItem implements Serializable {

    private String userName;
    private String itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserItem userItem = (UserItem) o;
        return Objects.equals(userName, userItem.userName) && Objects.equals(itemId, userItem.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, itemId);
    }

    public UserItem(String userName, String itemId) {
        super();
        this.userName=userName;
        this.itemId=itemId;
    }
}
