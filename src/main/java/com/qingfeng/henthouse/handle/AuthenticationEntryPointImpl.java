package com.qingfeng.henthouse.handle;

import com.alibaba.fastjson.JSON;
import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.enmus.ControlStatus;
import com.qingfeng.henthouse.utils.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 认证失败
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        e.printStackTrace();
        ApiResponseObject responseObject;
        if(e.getMessage().equals("Token非法")){
            responseObject = new ApiResponseObject(ControlStatus.AUTHENTICATION_FAILURE.getErrorCode(),e.getMessage(),"Token 非法");
        }else responseObject = new ApiResponseObject(ControlStatus.AUTHENTICATION_FAILURE.getErrorCode(),ControlStatus.AUTHENTICATION_FAILURE.getErrorMsg());

        WebUtils.renderString(response, JSON.toJSONString(responseObject));
    }
}
