package com.gubin.api.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.gubin.common.dto.ResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    // 进入controller之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader("token");
        //设置返回类型
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        if (StringUtils.isEmpty(token)) {
            response.getWriter().print(JSONObject.toJSON(ResponseDto.ERRORMSG("token失效")));
            return false;
        }
        return true;    //如果false，停止流程，api被拦截
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
