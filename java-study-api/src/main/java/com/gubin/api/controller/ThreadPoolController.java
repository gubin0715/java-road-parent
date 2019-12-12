package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "ThreadPoolController", description = "线程池")
public class ThreadPoolController {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @ApiOperation(value = "测试线程池")
    @PostMapping("testThreadPool")
    public ResponseDto testThreadPool() {
        for (int i = 1; i <= 10; i++) {
            threadPoolTaskExecutor.submit(() -> {
                System.out.println("**************测试线程**************");
            });
        }
        return ResponseDto.SUCCESS();
    }
}
