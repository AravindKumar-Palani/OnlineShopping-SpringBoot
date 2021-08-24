package com.eshop.controller;

import com.eshop.model.CategoryResponse;
import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingCategory;
import com.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController extends CommonController{

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public CategoryResponse getCategoryDetails() {
        return categoryService.getAllCategory();
    }

    @PostMapping("/insertCategory")
    public CommonResponse insertCategory(@RequestBody ShoppingCategory category) {
        return categoryService.insertCategoryDetail(category);
    }

    @GetMapping("/getCategory")
    public CategoryResponse getSelectedCategoryItems(@RequestParam(name = "id") String categoryId) {
        return categoryService.getSelectedCategory(categoryId);
    }

    @GetMapping(path = "/initialize")
    public CommonResponse loadData(){
        return categoryService.loadInitialData();
    }
}
