package com.gubin.api.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注入自定义拦截类到spring容器
     * @return
     */
    @Bean
    public HandlerInterceptor getInterceptor() {
        return new MyInterceptor();
    }

    //增加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor())    //指定拦截器类
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
