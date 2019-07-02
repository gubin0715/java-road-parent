package com.gubin.api.controller;

import com.gubin.common.domain.BackAdmin;
import com.gubin.common.dto.ResponseDto;
import com.gubin.service.BackAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@Api(value = "BackAdminController", description = "后台用户接口")
public class BackAdminController {

    @Resource
    private BackAdminService backAdminService;

    @ApiOperation(value = "获取后台用户列表")
    @RequestMapping(value = "/getBackAdminList", method = RequestMethod.POST)
    public ResponseDto getBackAdminList(@RequestBody(required = false) BackAdmin backAdmin) {
        try {
            List<BackAdmin> list = backAdminService.selectBackAdminList(backAdmin);
            return ResponseDto.SUCCESSDATA(list);
        } catch (Exception e) {
            log.error("获取后台用户列表异常",e);
            return ResponseDto.ERRORMSG("获取后台用户列表异常");
        }
    }
}
