package com.gubin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ServletComponentScan
@SpringBootApplication
public class JavaStudyApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApiApplication.class, args);
    }

}

