package com.hln.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study/interfaces/v1/user")
public class SampleFilterAnnotationController {

    @GetMapping("/test")
    public String testFilter(){
        System.out.println("执行了注解的Filter");
        return "annotation Filter";
    }
}
