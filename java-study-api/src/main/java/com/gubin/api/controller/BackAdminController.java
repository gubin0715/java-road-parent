package com.gubin.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gubin.api.config.redis.TokenRedisUtils;
import com.gubin.common.domain.BackAdmin;
import com.gubin.common.dto.ResponseDto;
import com.gubin.common.util.Algorithm;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            PageHelper.startPage(backAdmin.getPageNum(),backAdmin.getPageSize());
            List<BackAdmin> list = backAdminService.selectBackAdminList(backAdmin);
            return ResponseDto.SUCCESSDATA(new PageInfo<>(list));
        } catch (Exception e) {
            log.error("获取后台用户列表异常", e);
            return ResponseDto.ERRORMSG("获取后台用户列表异常");
        }
    }

    @ApiOperation(value = "添加后台用户")
    @RequestMapping(value = "/addBackAdminList", method = RequestMethod.POST)
    public ResponseDto addBackAdminList(@RequestBody(required = false) BackAdmin backAdmin) {
        try {
            BackAdmin b = new BackAdmin();
            b.setAdminCode(backAdmin.getAdminCode());
            List<BackAdmin> list = backAdminService.selectBackAdminList(b);
            if (list.size()>0) {
                return ResponseDto.ERRORMSG("用户名已存在");
            }
            backAdmin.setPassword(Algorithm.md5Encryption(backAdmin.getPassword()));
            backAdminService.insertBackAdmin(backAdmin);
            return ResponseDto.SUCCESS();
        } catch (Exception e) {
            log.error("添加后台用户异常", e);
            return ResponseDto.ERRORMSG("添加后台用户异常");
        }
    }

    @ApiOperation(value = "后台用户登录")
    @RequestMapping(value = "/backAdminLogin", method = RequestMethod.POST)
    public ResponseDto backAdminLogin(@RequestBody(required = false) BackAdmin backAdmin) {
        try {
            BackAdmin b = new BackAdmin();
            b.setAdminCode(backAdmin.getAdminCode());
            List<BackAdmin> list = backAdminService.selectBackAdminList(b);
            if (list.size() <= 0) {
                return ResponseDto.ERRORMSG("用户名不存在");
            }
            backAdmin.setPassword(Algorithm.md5Encryption(backAdmin.getPassword()));
            list = backAdminService.selectBackAdminList(backAdmin);
            if (list.size() <= 0) {
                return ResponseDto.ERRORMSG("用户名或密码错误");
            }
            String token = UUID.randomUUID().toString().replace("-", "");
            tokenRedisUtils.setUserByToken(token, list.get(0));
            Map map = new HashMap();
            map.put("userInfo",list.get(0));
            map.put("token",token);
            return ResponseDto.SUCCESSDATA(map);
        } catch (Exception e) {
            log.error("后台用户登录异常",e);
            return ResponseDto.ERRORMSG("后台用户登录异常");
        }
    }
}
