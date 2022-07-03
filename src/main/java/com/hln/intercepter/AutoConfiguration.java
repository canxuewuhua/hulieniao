package com.hln.intercepter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AutoConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bLoginInterceptor());
        registry.addInterceptor(cLoginInterceptor());
    }

    @Bean
    public BLoginInterceptor bLoginInterceptor() {
        return new BLoginInterceptor();
    }

    @Bean
    public CLoginInterceptor cLoginInterceptor() {
        return new CLoginInterceptor();
    }


    @Bean
    public FilterRegistrationBean registerCorsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(corsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(1);  //值越小，Filter越靠前。
        return registration;
    }

    @Bean
    public CORSFilter corsFilter(){
        return new CORSFilter();
    }
}
