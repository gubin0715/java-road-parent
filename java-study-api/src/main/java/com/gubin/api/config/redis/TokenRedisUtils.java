package com.gubin.api.config.redis;

import com.alibaba.fastjson.JSON;
import com.gubin.common.domain.BackAdmin;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenRedisUtils {

    @Autowired
    private RedisService redisService;


    /**
     * lm_admin登录Key 前缀
     */
    public static final String ADMIN_LOGIN = "ADMIN_LOGIN:";

    public BackAdmin getUserByToken(String token) throws Exception {
        String ob= redisService.getJsonString(ADMIN_LOGIN + token);
        if (StringUtils.isBlank(ob)) return null;
        return JSON.parseObject(ob,BackAdmin.class);
    }
    public boolean setUserByToken(String token,BackAdmin userEntity) throws Exception {
        return redisService.set(ADMIN_LOGIN + token, JSON.toJSONString(userEntity), (long) (60*60*24*7));
    }
    public void delUserByToken(String token) throws Exception {
        redisService.remove(ADMIN_LOGIN + token);
    }
    public boolean set(String key,String value) throws Exception {
        return redisService.set(key, value, (long) (60*5));
    }
    public static void main(String[]args){
        System.out.println((String)null);
    }
}
