package com.gubin.dubbo.service;

import com.gubin.dubbo.domain.User;

public interface TestService {
    String sayHello(String str);
    User findUser();
}
