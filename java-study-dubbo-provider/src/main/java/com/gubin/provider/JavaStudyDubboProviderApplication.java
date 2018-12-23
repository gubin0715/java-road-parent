package com.gubin.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource({"classpath:config/spring-dubbo.xml"})
public class JavaStudyDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStudyDubboProviderApplication.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

