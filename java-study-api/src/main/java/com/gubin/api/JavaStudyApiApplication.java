package com.gubin.api;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHasor()
@EnableHasorWeb()
@EnableSwagger2
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.gubin.api.config.hasor"})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.gubin"})
@EnableJpaRepositories(basePackages = {"com.gubin.repository"})
@EnableElasticsearchRepositories(basePackages = "com.gubin.repository")
@EntityScan(basePackages = {"com.gubin.common.entity"})
@MapperScan(basePackages = {"com.gubin.mapper"})
public class JavaStudyApiApplication {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(JavaStudyApiApplication.class, args);
    }

}

