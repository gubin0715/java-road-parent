package com.gubin.api.controller;

import com.alibaba.fastjson.JSON;
import com.gubin.api.config.rabbitmq.MsgProducer;
import com.gubin.common.dto.RabbitMqDto;
import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "TestRabbitMqController",description = "测试rabbitmq生产、消费消息")
public class TestRabbitMqController {

    @Autowired
    private MsgProducer msgProducer;

    @ApiOperation(value = "rabbitmq生产消息")
    @RequestMapping(value = "rabbitMq",method = RequestMethod.POST)
    public ResponseDto rabbitMq(@RequestBody RabbitMqDto rabbitMqDto){
        try {
            msgProducer.sendMsg(JSON.toJSONString(rabbitMqDto));
            return ResponseDto.SUSSCCEMSG("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.ERRORMSG("出现异常");
        }
    }
}
