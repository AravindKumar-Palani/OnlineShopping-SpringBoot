package com.eshop.controller;

import com.eshop.model.ShoppingItem;
import com.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController extends CommonController{

    @Autowired
    ItemService itemService;

    @PostMapping(path = "/insertItem")
    public void insertItem(@RequestBody ShoppingItem item) {
        itemService.insertItemIndividually(item);
    }

    @PostMapping(path = "/insertItems")
    public void insertItemBulk(@RequestBody List<ShoppingItem> itemList) {
        itemService.insertItems(itemList);
    }

    @GetMapping(path = "/getItem")
    public ShoppingItem getItemById(@RequestParam(name = "id") String itemId) {
        return itemService.getMySearchItem(itemId);
    }

    @GetMapping(path = "/getAllItems")
    public List<ShoppingItem> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(path = "/removeItem")
    public boolean removeItemById(@RequestParam(name = "id") String itemId) {
        return itemService.removeItemViaId(itemId);
    }

    @PostMapping("/updateItem")
    public void updateItem(@RequestBody ShoppingItem item) {
        itemService.updateItem(item);
    }
}
