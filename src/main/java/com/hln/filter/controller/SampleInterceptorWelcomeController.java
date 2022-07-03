package com.hln.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WelcomeController")
public class SampleInterceptorWelcomeController {

    @GetMapping("/welcome")
    public String welcome(){
        System.out.println("经过拦截器的welcomeController已经执行完毕！！！");
        return "welcome";
    }
}
