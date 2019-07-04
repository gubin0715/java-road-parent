package com.gubin.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gubin.api.config.redis.RedisService;
import com.gubin.common.dto.RedisDto;
import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Api(value = "RedisController", description = "redis相关操作")
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     * 存储redis
     *
     * @param redisDto
     * @return
     */
    @ApiOperation(value = "存储redis数据")
    @RequestMapping(value = "/setRedis", method = RequestMethod.POST)
    public ResponseDto setRedis(@RequestBody RedisDto redisDto) {
        try {
            redisService.set(redisDto.getKey(), JSON.toJSONString(redisDto));
            return ResponseDto.SUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.ERROR();
        }
    }

    /**
     * 从redis根据key取值
     *
     * @param key
     * @return
     */
    @ApiOperation(value = "从redis根据key取值")
    @RequestMapping(value = "/getRedis", method = RequestMethod.POST)
    @ApiImplicitParam(name = "key", value = "存储redis的key值", dataType = "string", required = true, paramType = "query")
    public ResponseDto getRedis(@RequestParam("key") String key) {
        try {
            Object data = redisService.get(key);
            if (Objects.isNull(data)) {
                return ResponseDto.ERRORMSG("不存在改key值");
            } else {
                RedisDto redisDto = JSONObject.parseObject(data.toString(), RedisDto.class);
                return ResponseDto.SUCCESSDATA(redisDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.ERROR();
        }
    }
}
