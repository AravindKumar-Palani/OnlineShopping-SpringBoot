package com.eshop.repo;

import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingRequest;
import com.eshop.model.UserAddress;
import com.eshop.model.UserDetails;
import com.eshop.util.CommonUtil;
import org.apache.catalina.filters.SessionInitializerFilter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class LoginRepo extends CommonRepo{

    @Autowired
    CartRepo cartRepo;

    @Autowired
    CommonUtil commonUtil;

    public CommonResponse authenticateUser(UserDetails user){
        CommonResponse response = new CommonResponse();

        try {
            if (user.isValidLoginEntry()) {
                Session session = getSession();
                UserDetails userData = session.find(UserDetails.class, user.getUserName());
                if (userData.equals(user)) {
                    response.setUserName(userData.getUserName());
                    response.setCartItems(cartRepo.fetchCartDetails(userData.getUserName()));
                    response.setDefaultAddress(commonUtil.getDefaultAddress(userData));
                    return setSuccess(response);
                } else {
                    return setFailure(response, "Invalid credentials! please try again!");
                }
            } else {
                return setFailure(response, "Please login!");
            }
        } catch (Exception exception) {
            return setFailure(response, exception);
        }
    }

    public CommonResponse userSignUp(UserDetails details) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            session.save(details);
            setSuccess(response);
        } catch (Exception exception) {
            setFailure(response, exception);
        }
        return  response;
    }

    public CommonResponse addUserAddress(UserAddress address) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            UserDetails user = session.find(UserDetails.class, address.getLoggedInUserName());
            List<UserAddress> addressList = user.getUserAddressList();
            addressList.add(address);
            user.setUserAddressList(addressList);
            session.saveOrUpdate(user);
            setSuccess(response);
        } catch (Exception exception) {
            setFailure(response, exception);
        }
        return  response;
    }

    public CommonResponse setAsDefaultAddress(UserAddress address) {
        CommonResponse response = new CommonResponse();
        try {
            Session session = getSession();
            UserDetails user = session.find(UserDetails.class, address.getLoggedInUserName());
            List<UserAddress> addressList = user.getUserAddressList();

            //updating previous default address
            UserAddress existingDefaultAddress = commonUtil.getDefaultAddress(user);
            addressList.remove(existingDefaultAddress);
            existingDefaultAddress.setDefault(false);
            addressList.add(existingDefaultAddress);

            //setting new default address
            addressList.remove(address);
            address.setDefault(true);
            addressList.add(address);

            user.setUserAddressList(addressList);
            session.saveOrUpdate(user);
            setSuccess(response);
        } catch (Exception exception) {
            setFailure(response, exception);
        }
        return  response;
    }
}
