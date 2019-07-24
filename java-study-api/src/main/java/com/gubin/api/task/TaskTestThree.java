package com.gubin.api.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskTestThree {
    @Scheduled(cron = "0/5 * * * * *")
    public void taskTestThree(){
        System.out.println("==============系统当前时间==============");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
