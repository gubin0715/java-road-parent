package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@Api(value = "TestNacosController", description = "测试动态刷新配置数据")
public class TestNacosController {

    @Value("${test_nacos_data}")
    private String test_nacos_data;

    /**
     * 测试动态刷新配置数据
     *
     * @return
     */
    @RequestMapping(value = "testNacosData", method = RequestMethod.POST)
    @ApiOperation(value = "测试动态刷新配置数据")
    public ResponseDto testNacosData() {
        log.info("测试动态刷新配置数据");
        return ResponseDto.SUCCESSDATA(test_nacos_data);
    }
}
