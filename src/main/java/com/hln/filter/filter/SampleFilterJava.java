//package com.hln.filter.filter;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//public class SampleFilterJava implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("SampleFilterJava--初始化Filter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("SampleFilterJava ---进入Target Resource之前的事情");
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("SampleFilterJava ---处理返回的response");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("SampleFilterJava ---销毁Filter");
//    }
//}
