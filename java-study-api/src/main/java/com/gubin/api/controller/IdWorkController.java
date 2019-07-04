package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import com.gubin.common.idwork.SnowflakeIdWorkerLock;
import com.gubin.common.idwork.SnowflakeIdWorkerSynchronized;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "IdWorkController", description = "统一发号器")
public class IdWorkController {

    @ApiOperation(value = "请求统一发号器Lock锁")
    @PostMapping("/idWorkLock")
    public ResponseDto idWorkLock() {
        try {
            SnowflakeIdWorkerLock idWork = new SnowflakeIdWorkerLock(1);
            long id = idWork.nextId();
            return ResponseDto.SUCCESSDATA(String.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.ERROR();
        }
    }

    @ApiOperation(value = "请求统一发号器Synchronized锁")
    @PostMapping("/idWorkSynchronized")
    public ResponseDto idWorkSynchronized() {
        try {
            SnowflakeIdWorkerSynchronized idWork = new SnowflakeIdWorkerSynchronized(1, 1);
            long id = idWork.nextId();
            return ResponseDto.SUCCESSDATA(String.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.ERROR();
        }
    }
}
