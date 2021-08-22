package com.eshop.repo;

import com.eshop.model.CategoryResponse;
import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingCategory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryRepo extends CommonRepo {

    public CommonResponse insertCategory(ShoppingCategory category) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            session.saveOrUpdate(category);
            setSuccess(response);
        } catch (Exception exception) {
            setFailure(response, exception);
        }
        return response;
    }

    public CategoryResponse getCategory(String categoryId) {
        CategoryResponse response = new CategoryResponse();
        try {
            Session session = getSession();
            ShoppingCategory category = session.find(ShoppingCategory.class, categoryId);
            Hibernate.initialize(category.getItemList());
            response.setCategory(category);
            setSuccess(response);
        } catch (Exception exception) {
            setFailure(response, exception);
        }
        return response;
    }

}
