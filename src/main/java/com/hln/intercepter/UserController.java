package com.hln.intercepter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/c/user")
public class UserController {

    @CAuthorized(value = CAuthorizedType.PUBLIC)
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUsers() {
//        Long merchantId = BLoginHolder.getMerchantId();
        return "";
    }
}
