package com.gubin.api.controller;

import com.gubin.api.config.redis.TokenRedisUtils;
import com.gubin.common.domain.BackAdmin;
import com.gubin.common.dto.ResponseDto;
import com.gubin.service.BackAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@Api(value = "BackAdminController", description = "后台用户接口")
public class BackAdminController {

    @Resource
    private BackAdminService backAdminService;
    @Autowired
    private TokenRedisUtils tokenRedisUtils;

    @ApiOperation(value = "获取后台用户列表")
    @RequestMapping(value = "/getBackAdminList", method = RequestMethod.POST)
    public ResponseDto getBackAdminList(@RequestBody(required = false) BackAdmin backAdmin) {
        try {
            List<BackAdmin> list = backAdminService.selectBackAdminList(backAdmin);
            /*String token = UUID.randomUUID().toString().replace("-","");
            tokenRedisUtils.setUserByToken(token,list.get(0));*/
            return ResponseDto.SUCCESSDATA(list);
        } catch (Exception e) {
            log.error("获取后台用户列表异常",e);
            return ResponseDto.ERRORMSG("获取后台用户列表异常");
        }
    }
}
