package com.gubin.api.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注入自定义拦截类到spring容器
     *
     * @return
     */
    @Bean
    public HandlerInterceptor getInterceptor() {
        return new MyInterceptor();
    }

    //增加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**")
                .excludePathPatterns("/interface-ui/**")
                .excludePathPatterns("/api/*")
                .excludePathPatterns("/testNacosData")
                .excludePathPatterns("/addBackAdminList")
                .excludePathPatterns("/backAdminLogin")
                .excludePathPatterns("/articleList")
                .excludePathPatterns("/addArticle")
                .excludePathPatterns("/articleAllList")
                .excludePathPatterns("/rabbitMq")
                .excludePathPatterns("/kafkaSend")
                .excludePathPatterns("/testThreadPool")
                .excludePathPatterns("/setRedis")
                .excludePathPatterns("/getRedis");
    }

    //如果swagger排除后仍被拦截，放开代码
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/
}
