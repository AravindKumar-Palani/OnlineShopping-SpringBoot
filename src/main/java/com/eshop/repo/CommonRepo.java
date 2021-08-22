package com.eshop.repo;

import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CommonRepo {
    @Autowired
    private SessionFactory sessionFactory;

    public List<ShoppingItem> itemList;

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public CommonResponse setSuccess(CommonResponse response) {
        response.setStatusCode("200");
        response.setStatusMessage("Transaction successful");
        return response;
    }

    public CommonResponse setFailure(CommonResponse response, Exception exception) {
        response.setStatusCode("400");
        response.setStatusMessage("Transaction failed" + exception.getMessage());
        return response;
    }
}
