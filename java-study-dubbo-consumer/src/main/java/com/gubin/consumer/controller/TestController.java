package com.gubin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gubin.dubbo.domain.User;
import com.gubin.dubbo.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @Reference(version = "1.0.0")
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return testService.sayHello("Hello springboot and dubbo!");
    }

    @GetMapping("user")
    public User user() {
        return testService.findUser();
    }

}
