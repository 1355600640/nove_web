package com.qingfeng.henthouse.handle;

import com.alibaba.fastjson.JSON;
import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.enmus.ControlStatus;
import com.qingfeng.henthouse.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 授权失败
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        e.printStackTrace();
        ApiResponseObject responseObject = new ApiResponseObject(ControlStatus.AUTHORIZATION_FAILURE.getErrorCode(),ControlStatus.AUTHENTICATION_FAILURE.name());
        WebUtils.renderString(response, JSON.toJSONString(responseObject));
    }
}
