package com.hln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@ServletComponentScan("com.hln.filter")
@EnableRetry
// 此处是加这个注解 不能在SampleFilterAnnotation类上加@Component
public class SpringBootHlnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHlnApplication.class, args);
	}
}
