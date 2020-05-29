package com.gubin.task.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestTask{

    @XxlJob("testTask")
    public ReturnT<String> test(String param) {
        System.out.println("SpringBoot2.x_exec执行器->"+ LocalDateTime.now());
        XxlJobLogger.log("test --》SpringBoot2.x_exec执行器->"+ LocalDateTime.now());
        return ReturnT.SUCCESS;
    }
}
