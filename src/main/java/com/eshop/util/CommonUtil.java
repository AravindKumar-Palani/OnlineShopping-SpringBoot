package com.eshop.util;

import com.eshop.model.CartItem;
import com.eshop.model.ShoppingItem;
import com.eshop.model.UserAddress;
import com.eshop.model.UserDetails;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommonUtil {

    public File getFileFromResource(String fileLocation) throws IOException {

        Resource resource = new ClassPathResource(fileLocation);
        InputStream input = resource.getInputStream();
        File file = resource.getFile();

        return file;
    }

    public UserAddress getDefaultAddress(UserDetails user) {
        List<UserAddress> userAddressList = user.getUserAddressList();
        return userAddressList.stream().filter(a -> a.isDefault()).collect(Collectors.toList()).get(0);
    }

    public List<ShoppingItem> getCuratedItemList(List<ShoppingItem> itemList, List<CartItem> cartItemList) {
         itemList.stream().forEach(item -> checkIfInCart(item, cartItemList));
         return itemList;

    }

    public ShoppingItem checkIfInCart(ShoppingItem item, List<CartItem> cartItemList) {
        cartItemList.forEach(cart -> {
            if (cart.getItemId().equalsIgnoreCase(item.getItemId()))
                item.setExistInCart(true);
            else
                item.setExistInCart(false);
        });
        return  item;
    }

    public String getCurrentTime() {
        return  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
}
