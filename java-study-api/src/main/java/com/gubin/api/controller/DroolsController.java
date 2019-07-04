package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.service.DroolsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "DroolsController", description = "drools相关")
public class DroolsController {

    @Autowired
    private DroolsService droolsService;

    @ApiOperation(value = "drools相关测试")
    @PostMapping("/drools")
    public ResponseDto drools() {
        return droolsService.drools();
    }
}
