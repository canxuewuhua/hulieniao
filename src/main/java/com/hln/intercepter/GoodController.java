package com.hln.intercepter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/b/goods")
public class GoodController {

    @BAuthorized(value = BAuthorizedType.PUBLIC)
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createGoods() {
//        Long merchantId = BLoginHolder.getMerchantId();
        return "";
    }
}
