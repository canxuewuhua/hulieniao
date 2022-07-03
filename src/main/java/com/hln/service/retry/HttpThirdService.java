package com.hln.service.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HttpThirdService implements IHttpThirdService{


    @Autowired
    private SingleThirdService singleThirdService;

    public String thirdHttp() throws Exception{
        return singleThirdService.thirdHttpB();
    }

}
