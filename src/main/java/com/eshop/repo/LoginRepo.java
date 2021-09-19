package com.eshop.repo;

import com.eshop.model.CommonResponse;
import com.eshop.model.ShoppingRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class LoginRepo extends CommonRepo{

    public CommonResponse authenticateUser(ShoppingRequest request){
        CommonResponse response = new CommonResponse();
        String name = request.getUserName();
        String password = request.getPassword();

        if(StringUtils.hasText(name) & StringUtils.hasText(password)) {
            if(name.equals("admin") & password.equals("pswd")) {
                return setSuccess(response);
            } else {
                return setFailure(response, "Invalid credentials! please try again!");
            }
        } else {
            return setFailure(response, "Please login!");
        }
    }
}
