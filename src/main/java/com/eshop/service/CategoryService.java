package com.eshop.service;

import com.eshop.model.CategoryResponse;
import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingCategory;
import com.eshop.repo.CategoryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public CommonResponse insertCategoryDetail(ShoppingCategory category) {
        logger.trace("Reached insert category method");
        logger.info("Request received " + category);
        CommonResponse response = categoryRepo.insertCategory(category);
        logger.info("Response received " + response);
        return response;
    }

    public CategoryResponse getSelectedCategory(String categoryId) {
        logger.trace("Reached get items based on category");
        logger.info("Request received " + categoryId);
        CategoryResponse response = categoryRepo.getCategory(categoryId);
        logger.info("Response received "+ response);
        return response;
    }

    public CommonResponse loadInitialData() {
        logger.trace("loading initial category and item data");
        CommonResponse response = categoryRepo.insertCategory();
        logger.info("Response received "+ response);
        return response;
    }

    public CategoryResponse getAllCategory() {
        logger.trace("getting All Category and Item data");
        CategoryResponse response =  categoryRepo.getAllCategory();
        logger.info("Response received "+ response);
        return response;

    }
}
