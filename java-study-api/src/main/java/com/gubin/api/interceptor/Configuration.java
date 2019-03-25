package com.gubin.api.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class Configuration extends WebMvcConfigurerAdapter {
    //增加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())    //指定拦截器类
                .addPathPatterns("/dateabout")
                .addPathPatterns("/encryptAndDecrypt")
                .addPathPatterns("/getPostJosnData")
                .addPathPatterns("/longitudeAndLatitude/**")
                .addPathPatterns("/mapSoft")
                .addPathPatterns("/mapListSoft")
                .addPathPatterns("/mapOut")
                .addPathPatterns("/aboutString")
                .addPathPatterns("/userInfoList")
                .addPathPatterns("/xmlAbout");
    }
}
