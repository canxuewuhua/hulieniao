//package com.hln.filter.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private SampleInterceptor sampleInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(sampleInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/**/LoginController/**/", "/**/error")
//                .excludePathPatterns("/error");
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }
//}
