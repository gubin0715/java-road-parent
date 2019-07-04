package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.common.entity.UserInfo;
import com.gubin.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Api(value = "UserInfoController", description = "用户信息相关")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 用户信息列表
     *
     * @return
     */
    @RequestMapping(value = "/userInfoList", method = RequestMethod.POST)
    @ApiOperation(value = "用户信息列表")
    public ResponseDto userInfoList() {
        try {
            List<UserInfo> userInfoList = userInfoService.getUserInfoByList();
            return ResponseDto.SUCCESSDATA(userInfoList);
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
    }
}
