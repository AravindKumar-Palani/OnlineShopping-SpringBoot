package com.eshop.service;

import com.eshop.model.CategoryResponse;
import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingCategory;
import com.eshop.model.ShoppingItem;
import com.eshop.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public CommonResponse insertCategoryDetail(ShoppingCategory category){
        return categoryRepo.insertCategory(category);
    }

    public CategoryResponse getSelectedCategory(String categoryId) {
        return categoryRepo.getCategory(categoryId);
    }
}
