package com.gubin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackages = {"com.gubin"})
@EnableJpaRepositories(basePackages = {"com.gubin.repository"})
@EntityScan(basePackages = {"com.gubin.common.entity"})
public class JavaStudyApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApiApplication.class, args);
    }

}

