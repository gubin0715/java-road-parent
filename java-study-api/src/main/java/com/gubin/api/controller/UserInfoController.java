package com.gubin.api.controller;

import com.gubin.api.domain.UserInfo;
import com.gubin.api.service.UserInfoService;
import com.gubin.common.ResultData;
import com.gubin.common.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "UserInfoController",description = "用户信息相关")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户信息列表
     * @return
     */
    @RequestMapping(value = "/userInfoList",method = RequestMethod.POST)
    @ApiOperation(value = "用户信息列表",notes = "用户信息列表")
    public ResultData userInfoList(){
        ResultData resultData = new ResultData();
        try {
            List<UserInfo> userInfoList = userInfoService.getUserInfoByList();
            resultData.setData(userInfoList);
            resultData.setCode(ReturnCode.RES_SUCCESS);
            resultData.setMsg("成功！");
        }catch (Exception e){
            System.out.println(e.toString());
            resultData.setCode(ReturnCode.RES_FAILED);
            resultData.setMsg("失败！");
        }
        return resultData;
    }
}
