package com.eshop.service;

import com.eshop.model.ShoppingItem;
import com.eshop.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public void insertItemIndividually(ShoppingItem item) {
        itemRepo.insertItem(item);
    }

    public void insertItems(List<ShoppingItem> items) {
        itemRepo.insertMultipleItems(items);
    }

    public List<ShoppingItem> getAllItems() {
        return itemRepo.getAllItems();
    }

    public List<ShoppingItem> getAllItems(String userName) {
        return itemRepo.getAllItems();
    }

    public ShoppingItem getMySearchItem(String itemId) {
        return itemRepo.getMatchingItem(itemId);
    }

    public boolean removeItemViaId(String itemId) {
        return itemRepo.removeItemById(itemId);
    }

    public void updateItem(ShoppingItem item) {
        itemRepo.updateItem(item);
    }
}
