package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Api(value = "StringAboutController", description = "字符串相关接口")
@RestController
public class StringAboutController {

    @RequestMapping(value = "/aboutString", method = RequestMethod.POST)
    @ApiOperation(value = "UUID、随机整数、截取、是否包含")
    public ResponseDto aboutString() {
        try {
            /**
             * 生成UUID
             */
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
            /**
             * 生成条件限制下随机整数（不等于条件）
             */
            Random rand = new Random();
            int a = rand.nextInt(1);
            System.out.println(a);
            /**
             * 用特殊符号截取字符串
             */
            String str = "a,b,c,d";
            List<String> list = Arrays.asList(str.split(","));
            /**
             * 字符串是否包含字符
             */
            boolean resutl = str.contains(",");
            System.out.println(resutl);
            //返回数据
            return ResponseDto.SUCCESS();
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
    }
}
