//package com.hln.filter.filter;
//
//import org.springframework.core.annotation.Order;
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
///**
// * 使用两种方式
// * 1、使用注解的方式SampleFilterAnnotation
// * 2、也可以使用java配置类的方式SampleFilterJava 配合SampleFilterJavaConfig配置类
// */
//
//@Order(2)
//@WebFilter(filterName = "sampleFilterAnnotation",urlPatterns = {"/study/interfaces/v1/user/*"})
//public class SampleFilterAnnotation implements Filter{
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("SampleFilterAnnotation---------初始化Filter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//        System.out.println("SampleFilterAnnotation------进入Target Resource之前做的事情......");
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("SampleFilterAnnotation-----处理返回的Response......");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("SampleFilterAnnotation-----销毁Filter");
//    }
//}
