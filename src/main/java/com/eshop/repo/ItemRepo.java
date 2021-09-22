package com.eshop.repo;

import com.eshop.model.CartItem;
import com.eshop.model.ShoppingItem;
import com.eshop.util.CommonUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemRepo extends CommonRepo {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    CommonUtil commonUtil;

    public void insertItem(ShoppingItem item) {
        //saving to DB
        Session session = getSession();
        session.save(item);

    }

    public void insertMultipleItems(List<ShoppingItem> items) {

        Session session = getSession();
        for (ShoppingItem item : items) {
            session.save(item);
        }
    }

    public List<ShoppingItem> getAllItems() {

        //fetching from db
        Session session = getSession();
        Query query = session.createQuery("from ShoppingItem");
        List<ShoppingItem> myItemList = query.getResultList();
        return myItemList;
    }

    public List<ShoppingItem> getAllItems(String userName) {

        //fetching from db
        Session session = getSession();
        Query query = session.createQuery("from ShoppingItem");
        List<ShoppingItem> myItemList = query.getResultList();
        List<CartItem> cartItems = cartRepo.fetchCartDetails(userName);

        return commonUtil.getCuratedItemList(myItemList, cartItems);
    }

    public ShoppingItem getMatchingItem(String itemId) {

        Session session = getSession();
        Query query = session.createQuery("from ShoppingItem where itemId =" + itemId);
        List<ShoppingItem> myItemList = query.getResultList();
        return myItemList.get(0);
    }

    public boolean removeItemById(String itemId) {
        Session session = getSession();
        Query query = session.createQuery("delete from ShoppingItem where itemId =" + itemId);
        return (query.executeUpdate() == 1) ? true : false;
    }

    public void updateItem(ShoppingItem keyItem) {
        Session session = getSession();
        session.saveOrUpdate(keyItem);
    }
}
