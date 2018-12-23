package com.gubin.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:config/spring-dubbo.xml"})
public class JavaStudyDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStudyDubboConsumerApplication.class, args);
    }

}

