package com.eshop.repo;

import com.eshop.model.ShoppingItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ItemRepo {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ShoppingItem> itemList;

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public boolean insertItem(ShoppingItem item) {
        if(null == itemList) {
            itemList = new ArrayList<ShoppingItem>();
        }

        //saving to DB
        Session session = getSession();
        session.save(item);


       return itemList.add(item);
    }

    public boolean insertMultipleItems(List<ShoppingItem> items) {
        if (null == itemList) {
            itemList = new ArrayList<ShoppingItem>();
        }

        //saving to DB
        Session session = getSession();
        for (ShoppingItem item : items) {
            session.save(item);
        }

        return itemList.addAll(items);
    }

    public List<ShoppingItem> getAllItems() {
        if(null == itemList) {
            return new ArrayList<ShoppingItem>();
        }
        return itemList;
    }

    public ShoppingItem getMatchingItem(String itemId) {
        ShoppingItem searchItem = new ShoppingItem();
        for(ShoppingItem item: itemList) {
            if(item.getItemId().equalsIgnoreCase(itemId)) {
                searchItem = item;
            }
        }
        return searchItem;
    }

    public boolean removeItemById(String itemId) {
        ShoppingItem searchItem = null;
        for(ShoppingItem item:itemList) {
            if(item.getItemId().equalsIgnoreCase(itemId)) {
                searchItem = item;
            }
        }
        if(null == searchItem) {
            return false;
        } else {
              return  itemList.remove(searchItem);
        }

    }

    public boolean updateItem(ShoppingItem keyItem) {
        ShoppingItem searchItem = null;
        for(ShoppingItem item: itemList ) {
            if(item.getItemId().equalsIgnoreCase(keyItem.getItemId())) {
                searchItem = item;
            }
        }
        if (null == searchItem) {
            return false;
        } else {
            itemList.remove(searchItem);
            return itemList.add(keyItem);
        }
    }
}
