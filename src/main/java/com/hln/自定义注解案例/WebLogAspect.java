package com.hln.自定义注解案例;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * 操作日志切面拦截
 *
 * @Filename: WebLogAspect.java
 * @Author: zhangshuai
 * <li>Version: 1.0</li>
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {

    private static final String SPLIT_STRING_M   = "=";
    private static final String SPLIT_STRING_DOT = ", ";

    @Pointcut("@annotation(com.hln.自定义注解案例.ActionLog)")
    public void webLog() {
    }

    /**
     * 环绕
     */
    @Around("webLog() && @annotation(actionLog)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, ActionLog actionLog) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            // 开始打印请求日志
            HttpServletRequest request = getRequest();

            String      urlParams   = getRequestParams(request);
            Integer     loginUserId = 10475;
            String      tel         = "15863987569";
            Integer     userType    = 1;

            // 打印请求 url
            log.info("请求 URI: {}\t{}", request.getMethod(), request.getRequestURI());
            log.info("访问者IP: {}", "127.0.0.1");
            log.info("请求轨迹: {}-{}-{} 在操作 [{}-{}]", loginUserId, tel, userType, actionLog.module(), actionLog.action());

            if (StringUtils.isNotEmpty(urlParams)) {
                log.info("请求参数: {}", urlParams);
            }
//            String body = (String) request.getAttribute(REQUEST_BODY_ATTR_KEY);
//            if (StringUtils.isNotEmpty(body)) {
//                log.info("请求主体: {}", body);
//            }

            stopwatch = Stopwatch.createStarted();
            Object result = proceedingJoinPoint.proceed();
            this.printTimes(stopwatch, result);
            return result;
        } catch (Throwable e) {
            log.error("【{}-{}】 发生异常: ", actionLog.module(), actionLog.action(), e);
            String error = actionLog.error();
            if (StringUtils.isEmpty(error)) {
                error = actionLog.action() + "失败";
            }
            return error;
        }
    }

    /**
     * 获取请求地址上的参数
     *
     * @param request
     * @return
     */
    private String getRequestParams(HttpServletRequest request) {
        StringBuilder       sb  = new StringBuilder();
        Enumeration<String> enu = request.getParameterNames();
        //获取请求参数
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            sb.append(name).append(SPLIT_STRING_M)
                    .append(request.getParameter(name));
            if (enu.hasMoreElements()) {
                sb.append(SPLIT_STRING_DOT);
            }
        }
        return sb.toString();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }

    private void printTimes(Stopwatch stopwatch, Object result) {
        log.info("响应结果: {}", result);
        log.info("执行耗时: {}ms\n", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
