package com.eshop.repo;

import com.eshop.model.CarouselLoader;
import com.eshop.model.CategoryResponse;
import com.eshop.model.ShoppingCategory;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository @Transactional
public class DataLoaderRepo extends CommonRepo{

    Logger logger = LoggerFactory.getLogger(DataLoaderRepo.class);

    public CategoryResponse getInitialData(){
        CategoryResponse response  = new CategoryResponse();

        try {
            Session session = getSession();
            Query query = session.createQuery("from ShoppingCategory");
            List<ShoppingCategory> myCategoryList = query.getResultList();
            response.setCategoryList(myCategoryList);

            Query carouselQuery = session.createQuery("from CarouselLoader");
            List<CarouselLoader> carouselList = carouselQuery.getResultList();
            response.setCarouselList(carouselList);
            setSuccess(response);
            logger.info("transaction successful "+response);
        } catch (Exception exception) {
            setFailure(response, exception);
            logger.error(exception.getLocalizedMessage());
        }
        return response;
    }
}
