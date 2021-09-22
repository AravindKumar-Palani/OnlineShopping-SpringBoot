package com.eshop.service;

import com.eshop.model.CategoryResponse;
import com.eshop.model.ShoppingRequest;
import com.eshop.repo.DataLoaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoaderService {

    @Autowired
    DataLoaderRepo dataRepo;

    public CategoryResponse getInitialData() {
        return dataRepo.getInitialData();
    }
}
