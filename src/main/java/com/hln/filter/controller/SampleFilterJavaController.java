package com.hln.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleJava/learn/java")
public class SampleFilterJavaController {

    @GetMapping("/filter")
    public String testJavaFilter(){
        System.out.println("执行testJavaFilter");
        return "testJavaFilter";
    }
}
