package com.gubin.api.controller;

import com.gubin.common.util.Longitudeandlatitude;
import com.gubin.common.util.ResultData;
import com.gubin.common.util.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "LongitudeAndLatitudeController", description = "经纬度接口")
@RequestMapping("/longitudeAndLatitude")
public class LongitudeAndLatitudeController {

    /**
     * 根据两个位置的经纬度计算距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    @ApiOperation(value = "根据两对经纬度计算两点之间距离", notes = "根据两对经纬度计算两点之间距离")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lat1", value = "纬度一", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lng1", value = "经度一", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lat2", value = "纬度二", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lng2", value = "经度一", dataType = "string", required = true, paramType = "query")
    })
    @RequestMapping(value = "/getDistance", method = RequestMethod.POST)
    public ResultData getdistance(@RequestParam("lat1") String lat1,     //纬度一
                                  @RequestParam("lng1") String lng1,     //经度一
                                  @RequestParam("lat2") String lat2,     //纬度二
                                  @RequestParam("lng2") String lng2) {    //经度二
        ResultData resultData = new ResultData();
        try {
            double distance = Longitudeandlatitude.getDistance(Double.parseDouble(lat1), Double.parseDouble(lng1), Double.parseDouble(lat2), Double.parseDouble(lng2));//你们的距离
            System.out.println("距离" + distance / 1000 + "公里");
            resultData.setCode(ReturnCode.RES_SUCCESS);
            resultData.setData("距离" + distance / 1000 + "公里");
            resultData.setMsg("成功！");
        } catch (Exception e) {
            System.out.println(e.toString());
            resultData.setCode(ReturnCode.RES_FAILED);
            resultData.setMsg("失败！");
        }
        return resultData;
    }
}
