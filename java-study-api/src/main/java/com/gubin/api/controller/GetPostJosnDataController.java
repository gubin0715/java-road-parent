package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.common.util.JsonPostData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "GetPostJosnDataController", description = "获取post请求数据")
public class GetPostJosnDataController {

    @RequestMapping(value = "/getPostJosnData", method = RequestMethod.POST)
    @ApiOperation(value = "获取post请求数据")
    public ResponseDto getPostJosnData(HttpServletRequest request) {
        try {
            //获取到post请求数据
            String json = JsonPostData.getRequestPostStr(request);
            return ResponseDto.SUCCESSDATA(json);
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
    }
}
