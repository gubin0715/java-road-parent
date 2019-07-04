package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "KafkaController", description = "kafka消息相关")
public class KafkaController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/kafkaSend", method = RequestMethod.POST)
    @ApiOperation(value = "发送kafka消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "kafka消息键值", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "message", value = "kafka消息值", dataType = "string", required = true, paramType = "query")
    })
    public ResponseDto sendKafka(@RequestParam(value = "key", required = true) String key, @RequestParam(value = "message", required = true) String message) {
        try {
            kafkaTemplate.send("test", key, message);
            logger.info("发送kafka成功.");
            return ResponseDto.SUCCESSDATA("发送kafka成功");
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return ResponseDto.ERRORMSG("发送kafka失败");
        }
    }
}
