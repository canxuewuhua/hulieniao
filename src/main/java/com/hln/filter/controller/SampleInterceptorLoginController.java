package com.hln.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LoginController")
public class SampleInterceptorLoginController {

    @GetMapping("/login")
    public String login(){
        System.out.println("LoginController已经执行");
        return "login";
    }
}
