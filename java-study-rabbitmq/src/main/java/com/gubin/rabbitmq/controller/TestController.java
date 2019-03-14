package com.gubin.rabbitmq.controller;

import com.gubin.rabbitmq.config.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MsgProducer msgProducer;

    @RequestMapping("rabbitMq")
    public String rabbitMq(){
        try {
            for(int i=0;i<100;i++) {
                msgProducer.sendMsg("第A" + i + "条消息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
