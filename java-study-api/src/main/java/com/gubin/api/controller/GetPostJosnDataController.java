package com.gubin.api.controller;

import com.gubin.common.util.JsonPostData;
import com.gubin.common.util.ResultData;
import com.gubin.common.util.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "GetPostJosnDataController", description = "获取post请求数据")
public class GetPostJosnDataController {

    /**
     * 获取json格式post请求数据
     *
     * @return
     */
    @RequestMapping(value = "/getPostJosnData", method = RequestMethod.POST)
    @ApiOperation(value = "获取post请求数据", notes = "获取post请求数据")
    public ResultData getPostJosnData(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try {
            //获取到post请求数据
            String josn = JsonPostData.getRequestPostStr(request);
            resultData.setCode(ReturnCode.RES_SUCCESS);
            resultData.setMsg("成功！");
            resultData.setData(josn);
        } catch (Exception e) {
            System.out.println(e.toString());
            resultData.setCode(ReturnCode.RES_FAILED);
            resultData.setMsg("失败！");
        }
        return resultData;
    }
}
