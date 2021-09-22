package com.eshop.repo;

import com.eshop.model.*;
import com.eshop.util.CommonLoggers;
import com.eshop.util.CommonUtil;
import com.eshop.util.ResourceConstants;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
@Transactional
public class CategoryRepo extends CommonRepo {

    @Autowired
    CommonUtil commonUtil;

    @Autowired
    CommonLoggers commonLogger;

    Logger logger = LoggerFactory.getLogger(CategoryRepo.class);

    //To insert individual category
    public CommonResponse insertCategory(ShoppingCategory category) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            session.saveOrUpdate(category);
            logger.trace("Db update successful");
            setSuccess(response);
        } catch (Exception exception) {
            commonLogger.addErrorLogs(logger, exception);
            setFailure(response, exception);
        }
        return response;
    }

    //To fetch items from category
    public CategoryResponse getCategory(String categoryId) {
        CategoryResponse response = new CategoryResponse();
        try {
            Session session = getSession();
            ShoppingCategory category = session.find(ShoppingCategory.class, categoryId);
            Hibernate.initialize(category.getItemList());
            response.setCategory(category);
            logger.trace("Db read successful");
            setSuccess(response);
        } catch (Exception exception) {
            logger.error("category fetch failed" + exception.getStackTrace());
            setFailure(response, exception);
        }
        return response;
    }

    //To fetch all available category
    public CategoryResponse getAllCategory() {
        CategoryResponse response = new CategoryResponse();
        try {
            Session session = getSession();
            Query query = session.createQuery("from ShoppingCategory");
            List<ShoppingCategory> myCategoryList = query.getResultList();
            response.setCategoryList(myCategoryList);
            logger.trace("Db read successful for reading all category");
            setSuccess(response);
        } catch (Exception exception) {
            logger.error("All Category fetch failed" + exception.getStackTrace());
            setFailure(response, exception);
        }
        return response;
    }

    //to load date from datasource initially to database
    public CommonResponse insertCategory() {

        CommonResponse response = new CommonResponse();

        try {

            Scanner categoryFileScanner = new Scanner(commonUtil.getFileFromResource(ResourceConstants.categoryListLocation));
            Scanner carouselFileScanner = new Scanner(commonUtil.getFileFromResource(ResourceConstants.carouselListLocation));
            Workbook workbook = new XSSFWorkbook(commonUtil.getFileFromResource(ResourceConstants.itemListLocation));


            List<ShoppingCategory> categoryList = new ArrayList<>();
            categoryFileScanner.nextLine();
            while (categoryFileScanner.hasNext()) {
                String[] arr = categoryFileScanner.nextLine().split(",");
                logger.trace(arr.toString());
                ShoppingCategory myCategory = new ShoppingCategory();
                myCategory.setCategoryId(arr[0]);
                myCategory.setName(arr[1]);
                myCategory.setImageUrl(arr[2]);
                categoryList.add(myCategory);
            }

            List<CarouselLoader> carouselList = new ArrayList<>();
            carouselFileScanner.nextLine();
            while (carouselFileScanner.hasNext()) {
                String[] arr = carouselFileScanner.nextLine().split(",");
                CarouselLoader carousel = new CarouselLoader();
                carousel.setCarouselId(arr[0]);
                carousel.setCarouselImageUrl(arr[1]);
                carouselList.add(carousel);
            }


            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i < 50; i++) {
                ShoppingItem item = new ShoppingItem();
                Row row = sheet.getRow(i);
                item.setCategoryId(Integer.toString((int) row.getCell(0).getNumericCellValue()));
                item.setItemId(Integer.toString((int) row.getCell(1).getNumericCellValue()));
                item.setName(row.getCell(2).getStringCellValue());
                item.setActualPrice((float) row.getCell(3).getNumericCellValue());
                item.setDiscountedPrice((float) row.getCell(4).getNumericCellValue());
                item.setDiscountedPercentage((int) row.getCell(5).getNumericCellValue());
                item.setUserRating(Integer.toString((int) row.getCell(6).getNumericCellValue()));
                item.setUserRatingCount(Integer.toString((int) row.getCell(7).getNumericCellValue()));
                item.setDescription(row.getCell(8).getStringCellValue());
                item.setImageUrls(row.getCell(8).getStringCellValue());

                for (ShoppingCategory category : categoryList) {
                    if (category.getCategoryId().equalsIgnoreCase(item.getCategoryId())) {
                        List<ShoppingItem> items = new ArrayList<>();
                        if (category.getItemList() != null) {
                            items = category.getItemList();
                        }
                        items.add(item);
                        category.setItemList(items);
                    }
                }
            }

            Session session = getSession();
            for (ShoppingCategory category : categoryList) {
                session.saveOrUpdate(category);
            }
            for (CarouselLoader carousel : carouselList) {
                session.saveOrUpdate(carousel);
            }
            logger.trace("initial Db load successful");
            setSuccess(response);
        } catch (FileNotFoundException exception) {
            logger.error("initial loading failed" + exception.getStackTrace());
            setFailure(response, exception);
        } catch (Exception exception) {
            logger.error("initial loading failed" + exception.getStackTrace());
            exception.printStackTrace();
            setFailure(response, exception);
        }
        return response;
    }

    public CommonResponse insertCategory(ShoppingRequest request) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            for (ShoppingCategory category : request.getCategoryList()) {
                session.saveOrUpdate(category);
            }
            for (CarouselLoader carousel : request.getCarouselList()) {
                session.saveOrUpdate(carousel);
            }
            logger.trace("initial Db load successful");
            setSuccess(response);
        }  catch (Exception exception) {
            logger.error("initial loading failed" + exception.getStackTrace());
            exception.printStackTrace();
            setFailure(response, exception);
        }
        return response;
    }
}
