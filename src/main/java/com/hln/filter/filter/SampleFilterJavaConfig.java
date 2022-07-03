//package com.hln.filter.filter;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SampleFilterJavaConfig {
//
//    @Bean
//    public FilterRegistrationBean javaFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        // 此处引入SampleFilterJava类
//        filterRegistrationBean.setFilter(new SampleFilterJava());
//        // 定义过滤的url
//        filterRegistrationBean.addUrlPatterns("/sampleJava/*");
//        filterRegistrationBean.setName("sampleFilterJavaConfig");
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }
//}
