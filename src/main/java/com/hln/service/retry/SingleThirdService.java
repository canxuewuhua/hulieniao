package com.hln.service.retry;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class SingleThirdService {

    private AtomicInteger count = new AtomicInteger(0);

    @Retryable(value = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public String thirdHttpB() throws Exception{
        String now = DateUtil.now();
        log.info("当前时间：{}", now);
        String response = "41001";
        if (response.equals("41001")){

            log.warn("start to retry : " + count.getAndIncrement());
            int num = count.get();
            if (num == 4){
                return "重试4次后正常返回结果 SUCCESS！";
            }else {
                throw new Exception("http请求返回accessToken异常，重试次数" + count.get());
            }

        }
        log.info("http请求成功");
        return "success";
    }

    @Recover
    public String recover(Exception e){
        log.error(e.getMessage());
        return "走的是重试后的处理补偿";
    }
}
