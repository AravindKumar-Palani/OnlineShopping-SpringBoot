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

    public boolean insertItemIndividually(ShoppingItem item) {
        return itemRepo.insertItem(item);
    }

    public boolean insertItems(List<ShoppingItem> items) {
        return itemRepo.insertMultipleItems(items);
    }

    public List<ShoppingItem> getAllItems() {
        return itemRepo.getAllItems();
    }

    public ShoppingItem getMySearchItem(String itemId) {
        return itemRepo.getMatchingItem(itemId);
    }

    public boolean removeItemViaId(String itemId) {
        return itemRepo.removeItemById(itemId);
    }

    public boolean updateItem(ShoppingItem item) {
        return itemRepo.updateItem(item);
    }
}
