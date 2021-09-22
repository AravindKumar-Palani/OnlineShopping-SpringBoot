package com.eshop.controller;

import com.eshop.model.CategoryResponse;
import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingCategory;
import com.eshop.model.ShoppingRequest;
import com.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class CategoryController extends CommonController{

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public CategoryResponse getCategoryDetails() {
        return categoryService.getAllCategory();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/insertCategory")
    public CommonResponse insertCategory(@RequestBody ShoppingCategory category) {
        return categoryService.insertCategoryDetail(category);
    }

    @GetMapping("/getCategory")
    public CategoryResponse getSelectedCategoryItems(@RequestParam(name = "id") String categoryId) {
        return categoryService.getSelectedCategory(categoryId);
    }

    @PostMapping(path = "/initialize")
    public CommonResponse loadData(@RequestBody ShoppingRequest request){
        return categoryService.loadInitialData(request);
    }
}
