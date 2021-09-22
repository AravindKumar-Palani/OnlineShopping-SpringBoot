package com.eshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetails {

    @Id
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String mailId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName")
    @Fetch(FetchMode.JOIN)
    private List<UserAddress> userAddressList;

    public boolean isValidLoginEntry() {
        if (StringUtils.hasText(this.userName) && StringUtils.hasText(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return userName.equals(that.userName) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
