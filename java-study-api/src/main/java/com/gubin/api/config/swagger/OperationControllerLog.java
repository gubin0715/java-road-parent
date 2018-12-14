package com.gubin.api.config.swagger;

import java.lang.annotation.*;

/**
 * @Description: 定义注解，拦截controller
 * @Author: vesus
 * @CreateDate: 2018/5/20 上午10:54
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)//元注解，定义注解被保留策略，一般有三种策略
//1、RetentionPolicy.SOURCE 注解只保留在源文件中，在编译成class文件的时候被遗弃
//2、RetentionPolicy.CLASS 注解被保留在class中，但是在jvm加载的时候北欧抛弃，这个是默认的声明周期
//3、RetentionPolicy.RUNTIME 注解在jvm加载的时候仍被保留
@Target({ElementType.METHOD}) //定义了注解声明在哪些元素之前
@Documented
public @interface OperationControllerLog {
    //定义成员
    String description() default "";//描述

    OperationType actionType() default OperationType.QUERY;//操作的类型，1、查询 2.添加 3、修改 4、删除
}
