package com.gubin.api.controller;

import com.gubin.api.rabbitmq.config.MsgProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "TestRabbitMqController",description = "测试rabbitmq生产、消费消息")
public class TestRabbitMqController {

    @Autowired
    private MsgProducer msgProducer;

    @ApiOperation(value = "rabbitmq生产消息",notes = "rabbitmq生产消息")
    @RequestMapping(value = "rabbitMq",method = RequestMethod.POST)
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
